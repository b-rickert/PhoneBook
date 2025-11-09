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
        return null;
    }

    public List<String> lookup(String name) {
        return null;
    }

    public String reverseLookup(String phoneNumber)  {
        return null;
    }

    public List<String> getAllContactNames() {
        return null;
    }

    public Map<String, List<String>> getMap() {
        return null;
    }
}
