package Abc;

import java.util.Comparator;
//SortByZip
public class SortEntryByZip implements Comparator<Contact> {
	public int compare(Contact contact1, Contact contact2) {
		return (int) (contact1.getZip() - contact2.getZip());
	}
}
