/*
  File proj3.java

  Description: Executable file that takes user input to create a phone directory.

  Date Last Edited: 11/10/19

  Authors: Brenton Kearney - bkearney@sandiego.edu
           Justin Cavalli - jcavalli@sandiego.edu
*/

import java.util.*;
import java.io.*;

public class proj3
{
    public static void main(String[] args)
    {
        PhoneDirectory directory = new PhoneDirectory();
        // loop until the user specifies to quit the program
        while(true)
        {
            // printing a menu for the user to select from
            Scanner kb = new Scanner(System.in);
            System.out.println("\nMenu");
            System.out.println("1. Load a previously saved phone directory from file");
            System.out.println("2. Add or change an entry");
            System.out.println("3. Remove an entry");
            System.out.println("4. Search for an entry");
            System.out.println("5. Display all entries");
            System.out.println("6. Save the current phone directory to a file");
            System.out.println("7. Quit the program");
            String in = kb.nextLine();
            if(in.equals("1"))
            {
                System.out.println("Enter the name of the file to be loaded.");
                String fileName = kb.nextLine();
                BufferedReader input = null;
                // handling errors in user input
                try
                {
                    input = new BufferedReader(new FileReader(fileName));
                    String inputLine;
                    StringTokenizer splitter;
                    while((inputLine = input.readLine()) != null)
                    {
                        splitter = new StringTokenizer(inputLine, ",");
                        directory.addOrChangeEntry(splitter.nextToken(), splitter.nextToken());
                    }
                }
                // printing out error messages
                catch(FileNotFoundException e)
                {
                    System.out.println("The file " + fileName + " does not exist.");
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
                finally
                {
                    try
                    {
                       if(input != null)
                            input.close();
                    }
                    catch(IOException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            // Adding or changing an entry
            else if(in.equals("2"))
            {
                System.out.println("Enter the full name for the directory entry.");
                String name = kb.nextLine();
                System.out.println("Enter the number for the directory entry.");
                String number = kb.nextLine();
                directory.addOrChangeEntry(name, number);
            }
            // Removing an entry
            else if(in.equals("3"))
            {
                System.out.println("Enter the full name to be removed from the directory.");
                String name = kb.nextLine();
                DirectoryEntry removed = directory.removeEntry(name);
                if(removed == null)
                    System.out.println("There is no entry by the name " + name);
            }
            // Search for a specific entry
            else if(in.equals("4"))
            {
                System.out.println("Enter the full name to be searched for.");
                String name = kb.nextLine();
                DirectoryEntry searched = directory.searchEntry(name);
                if(searched == null)
                {
                    // no entry matched the specified name
                    System.out.println("There is no entry by the name " + name);
                }
                else
                    System.out.println(searched.toString());
            }
            // display all of the entries
            else if(in.equals("5"))
            {
                directory.displayAllEntries();
            }
            // save the current version of the phone directory to a file
            else if(in.equals("6"))
            {
                // awaiting the user to input a specific filename
                System.out.println("Enter the name of the file to save the phone directory in.");
                String fileName = kb.nextLine();
                PrintWriter output = null;
                try
                {
                    output = new PrintWriter(new FileOutputStream(fileName));
                    for(int i =0; i<directory.getArrayList().size(); i++)
                    {
                        String temp = "";
                        temp += directory.getArrayList().get(i).getName() + "," + directory.getArrayList().get(i).getNumber();
                        output.println(temp);
                    }
                }
                // handling an error with the specified file
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
                finally
                {
                    if(output != null)
                        output.close();
                }
            }
            else if(in.equals("7"))
                break;
        }
    }
}
