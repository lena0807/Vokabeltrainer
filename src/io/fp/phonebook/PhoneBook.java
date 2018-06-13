package io.fp.phonebook;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class PhoneBook {

	private SortedMap<Integer, String> book = new TreeMap<>();
	
	public PhoneBook()
	{
		
	}
	
	public void createContact(String person, Integer...phoneNumbers) throws PhoneBookException
	{
		if(book.containsKey(phoneNumbers)==true) 
		{
			throw new PhoneBookException("Nummer bereits vorhanden");
		}
		
		for(Integer pn : phoneNumbers)
		{
			book.put(pn, person);			
		}
	}
	
	public void clearPhoneBook()
	{
		book.clear();
	}
	
	public Set<Integer> deleteEntriesOfAPerson​(String person)
	{
		Set<Integer> deletedPhonenumbers = new HashSet<>();
		
		for(Integer key : book.keySet())
		{
			if(key == person.indexOf(key))
			{
				deletedPhonenumbers.add(key);
			}
		}
		
		for(Integer key : book.keySet())
		{
			if(key == person.indexOf(key))
			{
				book.remove(key, person);
			}
		}

		return deletedPhonenumbers;
		
		
	}
	
	public String deleteEntryByPhoneNumber​(int phoneNumber) throws PhoneBookException
	{
		if(book.get(phoneNumber)==null)
		{
			throw new PhoneBookException("Phonenumber isn't in the Phonebook!");
		}
		else
		{
			String p = book.get(phoneNumber);
			book.remove(phoneNumber);
			return p;
		}

	}
	
	public Map<Integer,String> getBook()
	{

		return book;
		
	}
	
	public String getPerson​(int phoneNumber)
	{
		return book.get(phoneNumber);
	}

	
	public Set<Integer> getPhoneNumbers​(String person)
	{
		Set<Integer> p = new HashSet<>();
		
		for(Integer key : book.keySet())
		{
			if(key == person.indexOf(key))
			{
				p.add(key);
			}
		}
		
		return p;
	}
	
	
}
