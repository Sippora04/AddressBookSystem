package com.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AddressBook {
	Scanner sc = new Scanner(System.in);
	
	private ArrayList<Contacts> contactArray;
	private Map<String,Contacts> contactMap;
	private Map<String,Contacts> cityToContactEntryMap;
	private Map<String,Contacts> stateToContactEntryMap;
	
	public AddressBook() {
		contactArray = new ArrayList<>();
		contactMap = new HashMap<>();
		cityToContactEntryMap=new TreeMap<String,Contacts>();
		stateToContactEntryMap=new TreeMap<String,Contacts>();
	}
	
	public List<Contacts> getcontactArray() {
		return contactArray;
	}
	
	public Map<String, Contacts> getcontactMap() {
		return contactMap;
	}
	
	public void addNewContact () {
	//Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name: ");
	    String firstName = sc.next();
		for(int i=1; i>0; i++) {
			if(duplicateEntryValidation(firstName))
				continue;
		    else 
		    	break;
		}	
		System.out.println("Enter Last Name: ");
		String lastName = sc.next();
		System.out.println("Enter Phone Number: ");
		long phoneNumber = sc.nextLong();
		System.out.println("Enter Address: ");
		String address = sc.next();
		System.out.println("Enter City: ");
		String city = sc.next();
		System.out.println("Enter State: ");
		String state = sc.next();
		System.out.println("Enter pinCode: ");
		int zip = sc.nextInt();
		System.out.println("Enter EmailId: ");
		String email = sc.next();
		Contacts conObj = new Contacts(firstName, lastName, phoneNumber, address, city, state, zip, email);
		contactArray.add(conObj);
		contactMap.put(firstName, conObj);
	}
	
	public void editContact() {
		System.out.println("Enter The First Name whose contact details is to be edited: ");
		String firstname = sc.nextLine();
		Contacts conObj = contactMap.get(firstname);
		System.out.println("Enter the PhoneNumber: ");
		long number = sc.nextLong();
		conObj.setPhoneNumber(number);
		System.out.println("Enter the Address: ");
		String address = sc.next();
		conObj.setAddress(address);
		System.out.println("Enter the City: ");
		String city = sc.next();
		conObj.setCity(city);
		System.out.println("Enter the State: ");
		String state = sc.next();
		conObj.setState(state);
		System.out.println("Enter the Zip: ");
		int zip = sc.nextInt();
		conObj.setZip(zip);
		System.out.println("Enter the Email: ");
		String email = sc.next();
		conObj.setEmail(email);
	}
	
	public void deleteContact() {
		System.out.println("Enter The First Name to delete: ");
		String name = sc.nextLine();
		Contacts obj = contactMap.get(name);
		contactArray.remove(obj);
	}
	
	public void  multipleAddressBook() {
		for(int i = 1; i > 0; i++) {
			System.out.println("\n1. Add \n2. Edit \n3. Delete \n4.Sorting by Person Name");
			System.out.println("5. Sorting Contact by City \n6.Sorting Contact by Zip \n7. Sorting Contact by State \n8. Exit");
			System.out.println("\nEnter your choice");
			int select = sc.nextInt();
			switch(select) {
				case 1:	addNewContact();
						break;
				case 2:	if(contactArray.size() == 0)
							System.out.println("Please Enter the contact");
						else
							editContact();
						break;
				case 3:	if(contactArray.size() == 0)
							System.out.println("Plese Enter the contact");
						else
							deleteContact();
						break;
				case 4:	alphabeticSorting();
						break;
				case 5:	sortingByCity();
						break;
				case 6:	sortingByZip();
						break;
				case 7:	sortingByState();
						break;
				case 8:	System.exit(0);
						break;
				default: System.out.println("Invalid");
			}
	    }
	}
	
	public boolean duplicateEntryValidation(String name) {
		Predicate<Contacts> compareName = n -> n.equals(name);
		boolean result = contactArray.stream().anyMatch(compareName);
		return result;
	}
	
	public void sortingByCity() {
		List<Contacts> sortedList = contactArray.stream().sorted(Comparator.comparing(Contacts::getCity)).collect(Collectors.toList());
		sortedList.forEach(System.out::println);
	}
	
	public void sortingByZip() {
		List<Contacts> sortedList = contactArray.stream().sorted(Comparator.comparingInt(Contacts::getZip)).collect(Collectors.toList());
		sortedList.forEach(System.out::println);
	}	
	
	public void sortingByState() {
		List<Contacts> sortedList = contactArray.stream().sorted(Comparator.comparing(Contacts::getState)).collect(Collectors.toList());
		sortedList.forEach(System.out::println);
    }
	
	public void alphabeticSorting() {
		List<Contacts> sortedList = contactArray.stream().sorted(Comparator.comparing(Contacts::getFirstName)).collect(Collectors.toList());
		sortedList.forEach(System.out::println);
	}	
}
