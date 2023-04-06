package org.example;

import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, String> phoneList = new HashMap<>();

    public int add(String name, String phone){
        phoneList.putIfAbsent(name, phone);
        return phoneList.size();
    }

    public String findByNumber(String number){
        return null;
    }
}
