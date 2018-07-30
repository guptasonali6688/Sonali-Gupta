package com.zycus.threadAssignment2;

import java.io.*;
import java.util.*;

public class ContactList implements Runnable{

    List<Contact> contacts;
    private String filename;
    //Constructor
    public ContactList(List<Contact> contact, String filename) {
        super();
        this.contacts = contact;
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            System.out.println("Preparing to copy data to file "+filename);
            for(Contact c : contacts){                
                bw.write(c.toString());
                bw.write("\n");                
                bw.flush();
            }
            System.out.println("Data is copied to file "+filename);
        } catch (IOException e) {
            e.printStackTrace();
        }                
    }
    
}
.021