package io.fp.phonebook;

public class Test {

	public static void main(String[] args) throws PhoneBookException{
		// TODO Auto-generated method stub
		
		PhoneBook pb = new PhoneBook();
		
		pb.createContact("Hans August", 071713661);
		pb.createContact("Anna Peters", 07120);
		pb.createContact("Hans August", 071213);
		pb.createContact("Zara Zander", 071713611);
		
		System.out.println(pb.getBook());
		System.out.println("--------------------");
		
		// hallo
		System.out.println("Gelöschte Telefonnummern von Hans August: ");
		pb.deleteEntriesOfAPerson​("Hans August");
		
		System.out.println("Gelöschte Person der Nummer 071713611");
		pb.deleteEntryByPhoneNumber​(071713611);
		
		
		
		

	}

}
