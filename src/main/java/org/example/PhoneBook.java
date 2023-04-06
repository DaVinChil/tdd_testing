package org.example;

import java.util.HashMap;
import java.util.TreeSet;

public class PhoneBook {
    private HashMap<String, String> phoneList = new HashMap<>();
    private HashMap<String, String> nameList = new HashMap<>();

    public int add(String name, String phone){
        if(phoneList.get(name)==null && nameList.get(phone)==null){
            phoneList.put(name, phone);
            nameList.put(phone, name);
        }

        return phoneList.size();
    }

    public String findByNumber(String number){
        return nameList.get(number);
    }

    public String findByName(String name){
        return phoneList.get(name);
    }

    public void printAllNames(){

    }
}
