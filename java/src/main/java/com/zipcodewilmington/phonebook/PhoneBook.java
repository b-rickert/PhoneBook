package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook; // creates a map of the phonebook 

    public PhoneBook(Map<String, List<String>> map) {   // creates empty map as a phonebook class
        if (map == null) {                              // when the map is empty
            this.phonebook = new LinkedHashMap<>();     // create new hasp map
        } else {
            this.phonebook = map;                       // use existing map
        }
    }

    public PhoneBook() {                                // constructer that calls null constructer to create empty phonebook
        this(null);
    }

    public void add(String name, String phoneNumber) {            // method that adds phone number to name
        if (this.phonebook.containsKey(name)) {                   // if it contains input name
            this.phonebook.get(name).add(phoneNumber);            // get name and add phone number
        } else {
            List<String> phoneNumberList = new ArrayList<>();     // create new array list for phonenumber
            phoneNumberList.add(phoneNumber);                     // add the phonenumber 
            this.phonebook.put(name, phoneNumberList);            // and now add phonenumber to arraylist 
        }                    
    }                    


    public void addAll(String name, String... phoneNumbers) {
        for (int i = 0; i < phoneNumbers.length; i++);            // loops the array of phonenumbers
        this.add(name, phoneNumbers[i]);                          // adds phonenumbers in the array to specified names
    }

    public void remove(String name) {
        this.phonebook.remove(name);                              // removes the name from phonebook
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);                  // checking if name exists 
    }

        public boolean hasEntry(String name, String phoneNumber) { // checking if name has assigned phonenumber
            List<String> numbers = lookup(name);                   // get list of numbers for name
            if (numbers == null) {                                 
                return false;                                      // if it doesn't exist - return false
            }
            return numbers.contains(phoneNumber);                  // check if the list contains number
        }

    public List<String> lookup(String name) {                      // looks for name in phonebook
        if (this.phonebook.containsKey(name)) {                    // if it contains name
            return this.phonebook.get(name);                       // return list of numbers with name
        } else {
            return null;                                           // otherwise return nothing
        }
    }

    public String reverseLookup(String phoneNumber)  {       
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {  // loops through entries in phonebook    
            String name = entry.getKey();                           // takes the name
            List<String> numbers = entry.getValue();                // takes the list of numbers
            if (numbers.contains(phoneNumber)) {                    // checks if person has the number
                return name;                                        // if it does, return name
            }
        }
        return null;                                                // if not, return nothing
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());                 // creates a new array list and returns names in phonebook inside array list  
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;                                      // returns phonebook map
    }
}
