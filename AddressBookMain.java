import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AddressBookMain {
	
	private Map<String, Contacts> addressBook = new TreeMap<String, Contacts>();

	public void addContactToAddressBook(Contacts contact) {
		addressBook.put(contact.getFullName(), contact);
	}
	
	public void displayAddressBook() {
		for(Map.Entry<String,Contacts> contact : addressBook.entrySet()) {
			System.out.println(contact.getValue());
		}
	}
	
	public Contacts createContact() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter First Name:");
		String firstName = sc.next();
		
		System.out.println("Enter Last Name:");
		String lastName = sc.next();
		
		System.out.println("Enter address:");
		String address = sc.next();
		
		System.out.println("Enter city:");
		String city = sc.next();
		
		System.out.println("Enter state:");
		String state = sc.next();
		
		System.out.println("Enter zip code:");
		int zip = sc.nextInt();
		
		System.out.println("Enter phone No.:");
		String phoneNumber = sc.next();
		
		System.out.println("Enter email address:");
		String email = sc.next();
		sc.close();
		Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
		
		return contact;		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBookMain addressBookObject = new AddressBookMain();		
		System.out.println("Add new Contact(Y/N): ");
		String select = sc.next();
		switch(select) {
		case "Y": Contacts contact = addressBookObject.createContact();
				  addressBookObject.addContactToAddressBook(contact);
				  break;
		case "N": System.out.println("Cancel to add Contact");
				  break;
				  default: System.out.println("Invalid choice");
		}
		addressBookObject.displayAddressBook();
		sc.close();
	}
}