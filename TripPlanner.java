import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;
public class TripPlanner {
//	https://stackoverflow.com/questions/42332273/scanning-doubles-when-i-separate-decimals-with-comma-or-dot
	
	private static Scanner input;
	private static DecimalFormat myFormatter;
	public static void main(String[] args) {
		//resolve o problema do scanner pegar o padrão numérico do pais da compilação ( double e float com virgula)
		Locale.setDefault(Locale.US);
		myFormatter = new DecimalFormat("###.##");
		input = new Scanner(System.in);
		//greeter();
		tripDetails();
	}
	public static void greeter() {
		printer("What is your name? ");
		String mySuperVar = readerLine();
		printer( "Nice to meet you " + mySuperVar + ", where are you travelling to? ");
		mySuperVar = readerLine();
		printer("Great! " + mySuperVar + " sounds like a great trip\n");
		endSection();
	}
	public static void printer (String arg) {
		System.out.print(arg);
	}
	public static String readerLine () {
		return input.nextLine();
		
	}
	public static double readerDouble () {
		return input.nextDouble(); // só aceita virgula.... será por causa do local?
	}
	public static int readerint () {
		return input.nextInt();
	}
	public static void tripDetails () {
		double money = 0.0;
		int daysTravelling = 0;
		double localToDollarRatio = 0.0;
		String alias = "";
		printer("How many days are you going to spend travelling? ");
		daysTravelling = readerint();
		printer("How much money, in USD, are you planning to spend on your trip? ");
		money = readerDouble();
		readerLine(); // retira \n do input double
		printer("What is the three letter currency symbol for your travel destination? ");
		alias = readerLine();
		
		printer("How many " + alias.trim() + " are there in 1 USD? ");
		localToDollarRatio = readerDouble();
		readerLine();
		printer("\n");
		
		printer("If you are travelling for 14 days that is the same as " + daysTravelling*24 + " hours or " + daysTravelling * 24 * 60 + " minutes\n" );
		printer("If you are going to spend $" + myFormatter.format(money) +" " + alias + " that means per day you can spend up to $" + myFormatter.format(money/daysTravelling) + " " + alias + "\n" );
		printer("Your total budget in MXC is " + myFormatter.format(money*localToDollarRatio) +" " + alias + ", which per day is " + myFormatter.format(money*localToDollarRatio/daysTravelling) + " " + alias + "\n" );
		
		endSection();
		return;
	}
	public static void endSection () {
		printer("***********\n\n\n");
	}
}
