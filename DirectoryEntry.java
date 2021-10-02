/*
 *   File DirectoryEntry.java
 *
 *   Description: Object containing a name and phone number to be used in PhoneDirectory.
 *
 *   Date Last Edited: 11/10/19
 *
 *   Authors: Brenton Kearney - bkearney@sandiego.edu
 *            Justin Cavalli - jcavalli@sandiego.edu
 */

public class DirectoryEntry
{
    private String name;
    private String number;

    public DirectoryEntry(String name, String number)
    {
        this.name = name;
        this.number = number;
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String toString()
    {
        return "name: " + name + " number: " + number;
    }

    public int hashCode()
    {
        return name.hashCode() + number.hashCode();
    }

    public boolean equals(Object obj)
    {
        if(((DirectoryEntry)obj).getName().equalsIgnoreCase(this.name))
            return true;
        return false;
    }
}