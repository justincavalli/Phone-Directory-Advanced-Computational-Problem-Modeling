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

    }

    public String addOrChangeEntry(String name, String number)
    {
        String oldNumber = null;
        for(DirectoryEntry person : theDirectory)
        {
            if(person.getName().equalsIgnoreCase(name))
            {
                oldNumber = person.getNumber();
                person.setNumber(number);
                return oldNumber;
            }
        }
        theDirectory.add(new DirectoryEntry(name, number));
        return oldNumber;
    }

    public DirectoryEntry searchEntry(String name)
    {
        for(DirectoryEntry person : theDirectory)
        {
            if(person.getName().equalsIgnoreCase(name))
                return person;
        }
        return null;
    }

    public DirectoryEntry removeEntry(String name)
    {
        if(searchEntry(name) != null)
        {
            return theDirectory.remove(theDirectory.indexOf(searchEntry(name)));
        }
        return null;
    }

    public void displayAllEntries()
    {
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
