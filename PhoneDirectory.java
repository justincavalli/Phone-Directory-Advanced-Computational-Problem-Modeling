/*
 *   File PhonDirectory.java
 *
 *   Description: Implements an array of DirectoryEntry Objects.
 *
 *   Date Last Edited: 11/10/19
 *
 *   Authors: Brenton Kearney - bkearney@sandiego.edu
 *            Justin Cavalli - jcavalli@sandiego.edu
*/

import java.util.*;

public class PhoneDirectory
{
    private ArrayList<DirectoryEntry> theDirectory = new ArrayList<>();

    public PhoneDirectory()
    {
        // constructor with no variables to initialize
    }

    public String addOrChangeEntry(String name, String number)
    {
        String oldNumber = null;
        for(DirectoryEntry person : theDirectory)
        {
            // check if an entry already exists for the given name
            if(person.getName().equalsIgnoreCase(name))
            {
                // updates the entry's number
                oldNumber = person.getNumber();
                person.setNumber(number);
                return oldNumber;
            }
        }
        // an entry does not exist for the given name, so create a new one
        theDirectory.add(new DirectoryEntry(name, number));
        return oldNumber;
    }

    public DirectoryEntry searchEntry(String name)
    {
        for(DirectoryEntry person : theDirectory)
        {
            // if an entry with the given name exists, return it
            if(person.getName().equalsIgnoreCase(name))
                return person;
        }
        return null;
    }

    public DirectoryEntry removeEntry(String name)
    {
        if(searchEntry(name) != null)
        {
            // if an entry with the given name exists, remove it
            return theDirectory.remove(theDirectory.indexOf(searchEntry(name)));
        }
        return null;
    }

    public void displayAllEntries()
    {
        // loops through each entry in the directory printing out the information
        for(DirectoryEntry person : theDirectory)
        {
            System.out.println(person.toString());
        }
    }

    public List<DirectoryEntry> getArrayList()
    {
        return theDirectory;
    }
}
