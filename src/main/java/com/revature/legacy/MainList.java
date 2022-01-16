//This is a custom data structure that uses the names of entries for their own element in storage.
//Parsing the name allows for faster searching at the expense of a larger size.
//The actual size is currently 5 times the number of entries.
//
//
//package com.revature.utils;
//
//import com.revature.models.PersonType;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//public class MainList {
//
//    private int estimatedSize;
//    private int sizeRatio = 5;
//
//    List<LinkedList<PersonType>> arrayLists = new ArrayList<>();
//
//
//    //Default constructor, uses a size of 100 to start
//    public MainList()
//    {
//        estimatedSize = 100;
//
//        for(int i = 0; i < estimatedSize * sizeRatio; i++)
//        {
//            arrayLists.add(new LinkedList<PersonType>());
//        }
//    }
//
//    //Custom constructor that allows choosing of total size
//    public MainList(int estimatedSize)
//    {
//        this.estimatedSize = estimatedSize;
//
//        for(int i = 0; i < estimatedSize * sizeRatio; i++)
//        {
//            arrayLists.add(new LinkedList<PersonType>());
//        }
//    }
//
//
//    //Uses the algorithm to find the correct location for an entry, before adding it
//    public void addItem(PersonType newPerson)
//    {
//        int newEntryIndex = convertAlgorithm(newPerson.getName());
//
//        //if the list is null, create a new one and add the entry too it
//        if(arrayLists.get(newEntryIndex)==null)
//        {
//            LinkedList<PersonType> newList = new LinkedList<>();
//            newList.add(newPerson);
//            arrayLists.add(newList);
//        }
//        else
//        {
//            //add the person to the existing list
//            arrayLists.get(newEntryIndex).add(newPerson);
//        }
//    }
//
//    //Uses the algorithm to search for an item, returns null if none is found
//    public PersonType getItem(String personName)
//    {
//        int entryIndex = convertAlgorithm(personName);
//        //call conversion and search through the linked list for a match, return the object
//        if(arrayLists.get(entryIndex) == null)
//            return null;
//        else
//        {
//            for(PersonType p: arrayLists.get(convertAlgorithm(personName)))
//            {
//                if(p.getName() == personName)
//                    return p;
//            }
//        }
//
//
//        return (null);
//    }
//
//    //Iterates through the list and displays every entry
//    public void iterateList()
//    {
//        for(LinkedList<PersonType> a: arrayLists)
//        {
//            //if there are no entries in the linked list, if there is one, and if there are several
//            if(a.size() == 0)
//                break;
//            else if(a.size()== 1)
//            {
//                System.out.println((a.get(1).getName()));
//            }
//            else
//            {
//                for(int i = 0; i < a.size(); i++)
//                {
//                    //loop through the individual linked list for all entries
//                    System.out.println((a.get(i)).getName());
//                }
//            }
//        }
//    }
//
//    //Convert string to an element for the array within a certain range
//    //Typically done by adding all the characters together and dividing until within range.
//    //Will always return the same number if given the same string.
//    public int convertAlgorithm(String name)
//    {
//        int elementCount = 0;
//
//        //Add all characters together
//        for(int i = 0; i < name.length(); i++)
//        {
//            if(name.charAt(i) == ' ')
//            {
//                continue;
//            }
//            else
//            {
//                elementCount += name.charAt(i);
//            }
//        }
//
//        //ensure the element is a valid index
//        while(elementCount < 0 | elementCount > arrayLists.size() - 1)
//        {
//             if(elementCount < 0)
//             {
//                 elementCount = 0;
//             }
//             else if(elementCount > arrayLists.size() - 1)
//             {
//                 elementCount = elementCount / 2;
//             }
//        }
//        return 0;
//    }
//}
