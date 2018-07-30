package com.zycus.threadAssignment2;

import java.util.*;

public class App {
    public static void main(String args[]) {
        List<Contact> contact = new ArrayList<>();
        contact.add(new Contact("Sonali", "Gupta", "gsonali6688@gmail.com", 99090333, 22));
        contact.add(new Contact("Megha", "Shanbhag", "ms@gmail.com", 78980909, 20));
        contact.add(new Contact("Shital", "Shetty", "ss@gmail.com", 87889894, 22));
        contact.add(new Contact("Asmita", "Kharat", "ak@gmail.com", 9767222, 24));
        contact.add(new Contact("Dikha", "Singh", "ds@gmail.com", 6282892, 22));
        contact.add(new Contact("Pranali", "Bagate", "pn@gmail.com", 28789803, 23));
        contact.add(new Contact("Rupali", "Gupta", "ms@gmail.com", 27873893, 22));
        contact.add(new Contact("Sushant", "Singh", "ss@gmail.com", 9488984, 22));
        contact.add(new Contact("Vishal", "Patil", "vp@gmail.com", 80309033, 23));
        contact.add(new Contact("Priyanka", "Bhosale", "pb@gmail.com", 38789892, 22));
        contact.add(new Contact("Raj", "Chavan", "rc@gmail.com", 37889022, 22));
        
        ContactList contactlist1 = new ContactList(contact, "D:/ContactFile/file1.txt");
        ContactList contactlist2 = new ContactList(contact, "D:/ContactFile/file2.txt");
        ContactList contactlist3 = new ContactList(contact, "D:/ContactFile/file3.txt");
        
        Thread t1 = new Thread(contactlist1);
        Thread t2 = new Thread(contactlist2);
        Thread t3 = new Thread(contactlist3);
        
        t1.start();
        t2.start();
        t3.start();
        
    }
}
