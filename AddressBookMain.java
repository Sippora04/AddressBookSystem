import java.util.Scanner;

public class AddressBookMain
{
	private static Scanner sc = new Scanner(System.in);;

	public static void main(String args[])
	{	
		System.out.print("Enter First Name:");
        	String firstName = sc.nextLine();
        	System.out.print("Enter Last Name:");
        	String lastName = sc.nextLine();
        	System.out.print("Enter Address:");
        	String address = sc.nextLine();
        	System.out.print("Enter City:");
        	String city = sc.nextLine();
        	System.out.print("Enter state:");
        	String state = sc.nextLine();
        	System.out.print("Enter Pincode/Zipcode:");
        	int pinCode = sc.nextInt();
        	System.out.print("Enter Phone No:");
        	int phoneNumber = sc.nextInt();
        	System.out.print("Enter email Id:");
        	String emailId = sc.nextLine();
	}
}
