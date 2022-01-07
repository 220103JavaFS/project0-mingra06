package com.revature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainList {


    List<LinkedList<PersonType>> arrayLists = new ArrayList<>();


    //Uses the algorithm to find the correct location for an entry, before adding it
    public void addItem(PersonType newPerson)
    {
        int newEntryIndex = convertAlgorithm(newPerson.getName());

        //if the list is null, create a new one and add the entry too it
        if(arrayLists.get(newEntryIndex)==null)
        {
            LinkedList<PersonType> newList = new LinkedList<>();
            newList.add(newPerson);
            arrayLists.add(newList);
        }
        else
        {
            //add the person to the existing list
            arrayLists.get(newEntryIndex).add(newPerson);
        }
    }

    //Uses the algorithm to search for an item, returns null if none is found
    public PersonType getItem(String personName)
    {
        int entryIndex = convertAlgorithm(personName);
        //call conversion and search through the linked list for a match, return the object
        if(arrayLists.get(entryIndex) == null)
            return null;
        else
        {
            for(PersonType p: arrayLists.get(convertAlgorithm(personName)))
            {
                if(p.getName() == personName)
                    return p;
            }
        }


        return (null);
    }

    //Iterates through the list and displays every entry
    public void iterateList()
    {
        for(LinkedList<PersonType> a: arrayLists)
        {
            //if there are not entries in the linked list, if there is one, and if there are several
            if(a.size() == 0)
                break;
            else if(a.size()== 1)
            {
                System.out.println((a.get(1).getName()));
            }
            else
            {
                for(int i = 0; i < a.size(); i++)
                {
                    //loop through the linked list for all entries
                    System.out.println((a.get(i)).getName());
                }
            }
        }
    }

    public int convertAlgorithm(String Name)
    {
        //Convert string to an element for the array within range
        return 0;
    }
}
