package io.fp.phonebook;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PhoneBookTest {

	// Hausaufgabe: Methoden erstellen -> testDeleteEntriesOfAPerson() & testDeleteEntriesByPhoneNumber() 
	// & testCreateSamePhoneNumber() (Test soll klappen wenn Exception geworfen wird)
	
	PhoneBook pb;
	Integer[] numbers = {1, 2, 3};
	
	@Before 
	// @BeforePhoneBook wird dadurch bei jedem Test neu erstellt und die Werte des vorherigen Tests sind weg
	
	public void setUp()
	{
		pb = new PhoneBook();
	}
	
	@Test
	public void testDeleteEntriesOfAPerson()
	{
		try{
			pb.createContact("Person", numbers);	
			pb.deleteEntriesOfAPerson​("Person");
			assertEquals(null, pb.getPhoneNumbers​("Person"));
		}
		catch(PhoneBookException e){
			fail("Should not have thrown: " + e);
		}

	}	
	
	@Test
	public void testDeleteEntriesByPhoneNumber()
	{
		try{
			pb.createContact("Person", 345);
			pb.deleteEntryByPhoneNumber​(345);
			assertEquals(null, pb.getPhoneNumbers​("Person"));
		}
		catch(PhoneBookException e){
			fail("Should not have thrown: " + e);
		}

	}
	
	@Test(expected = PhoneBookException.class)
	public void testCreateSamePhoneNumber()
	{
		try{
			pb.createContact("Person", 123);
			pb.createContact("Person 2", 123);
		}
		catch(PhoneBookException e){
			fail("Should not have thrown: " + e);
		}

	}
	
	
	
	
	
	@Test
	public void testCreateContactSingleNumber()
	{
		try{
			pb.createContact("Person", 123);	
			assertEquals("Person", pb.getPerson​(123));
			assertEquals(1, pb.getPhoneNumbers​("Person").size());
		}
		catch(PhoneBookException e){
			fail("Should not have thrown: " + e);
		}

	}
	
	@Test
	public void testCreateContactArray()
	{
		try {
			pb.createContact("Person", numbers);
			for(int i=0; i<numbers.length; i++)
			{
				assertEquals(true, pb.getPhoneNumbers​("Person").contains(numbers[i]));
			}
			
			assertEquals(numbers.length, pb.getPhoneNumbers​("Person").size());
		}
		catch(PhoneBookException e) {
			fail("Should not have thrown: " + e);
		}
	}
}
