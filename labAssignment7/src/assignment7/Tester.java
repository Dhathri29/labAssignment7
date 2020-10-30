package assignment7;
import java.util.*;
import java.util.stream.Collectors;
public class Tester {
public static void main(String[] args) {
	List<Transaction> transaction = getAllTransactions();
	
	
	
	//Find all transactions in the year 2011 and sort them by value (small to high)
	
	List<Transaction> AllTransactionsInYear2011 =transaction.stream().filter(y->y.getYear()==2011)
			                                                .sorted((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue())).collect(Collectors.toList());
	AllTransactionsInYear2011.forEach(list -> System.out.println(list));

	
	
	//What are all the unique cities where the traders work?
	List<Trader> trade= transaction.stream().map(t->t.getTrader()).distinct().collect(Collectors.toList());
	
	
	
	//Find all traders from delhi and sort them by name.
	System.out.println("--------Traders from delhi-------");
	List<Trader> DelhiTraders = trade.stream().filter(city->city.getCity().equals("delhi")).sorted((o1, o2) -> o1.getName()
			                                                             .compareTo(o2.getName())).collect(Collectors.toList());
			
	DelhiTraders.forEach(trader->System.out.println(trader));
	
	
	
	//Return a string of all traders names sorted alphabetically.
	List<Trader> TradersSortedAlphabetically = trade.stream()
			.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
		.collect(Collectors.toList());

System.out.println(TradersSortedAlphabetically);


//Are any traders based in Jaipur?
boolean JaipurTraders = trade.stream().anyMatch(city->city.getCity().equals("jaipur"));
if(JaipurTraders) 
  System.out.println("traders are from jaipur also");
else 
	System.out.println("No traders from jaipur");



//Print all transactions values from the traders living in delhi

List<Integer> TransactionsFromDelhi = transaction.stream().filter(city->city.getTrader().getCity().equals("delhi")).map(value -> value.getValue())
.collect(Collectors.toList());

TransactionsFromDelhi.forEach(getValue->System.out.println(getValue));



//Whats the highest value of all the transactions?
OptionalInt maxValueFromTransactions=transaction.stream().mapToInt(value->value.getValue()).max();

System.out.println(maxValueFromTransactions);
}

private static List<Transaction> getAllTransactions() {

	Trader ram= new Trader("ram", "delhi");
	Trader kapil= new Trader("kapil","noida");
	Trader raj= new Trader("raj","banglore");
	Trader ekta= new Trader("ekta","banglore");
	List<Transaction> transactions = Arrays.asList(
			new Transaction(ram, 2011, 300),
			new Transaction(ram, 2012, 1000),
			new Transaction(kapil, 2011, 400),
			new Transaction(raj, 2012, 710),
			new Transaction(ekta, 2012, 700),
			new Transaction(ekta, 2012, 950)
			);
	
	return transactions;
}

}
