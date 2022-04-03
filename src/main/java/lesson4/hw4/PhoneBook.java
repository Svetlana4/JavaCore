package lesson4.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();


    private void add(String name, String number) {

        if (phoneBook.containsKey(name)) {
            ArrayList<String> existingList = phoneBook.get(name);
            existingList.add(number);
        } else {
            ArrayList<String> newList = new ArrayList<>(Arrays.asList(number));
            phoneBook.put(name, newList);
        }

    }

    private ArrayList<String> get(String name) {

        return phoneBook.get(name);
    }

    void printUser (String name){

        if (phoneBook.get(name) == null){
            System.out.println(name + " : " + "Такого абонента нет");
        }else {
            System.out.println(name + " : " + phoneBook.get(name));
        }
    }

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "8-923-563-34-49");
        phoneBook.add("Петрова", "8-943-507-32-19");
        phoneBook.add("Сидорова", "8-965-423-12-14");
        phoneBook.add("Петухов", "8-973-587-31-76");
        phoneBook.add("Петрова", "8-943-123-32-12");
        phoneBook.add("Иванов", "8-951-512-33-19");
        phoneBook.add("Cоколов", "8-871-517-92-19");

        phoneBook.get("Иванов");
        phoneBook.get("Сидорова");
        phoneBook.get("Петрова");
        phoneBook.get("Иванов");
        phoneBook.get("Cоколов");
        phoneBook.get("Петухов");


        phoneBook.printUser ("Иванов");
        phoneBook.printUser ("Cоколов");
        phoneBook.printUser ("Петров");

    }



}
