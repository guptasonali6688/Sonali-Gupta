package com.zycus.threadAssignment1;

import java.io.*;

public class FileCopy implements Runnable{
    private String source, destination;

    //Constructor
    public FileCopy(String source, String destination) {
        super();
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void run() {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream(source);
            fout = new FileOutputStream(destination);
            byte[] buffer = new byte[1000];
            
            int len = fin.read(buffer, 0, 1000);
            while(len > 0) {
                fout.write(buffer, 0, 1000);
                fout.flush();
                len = fin.read(buffer, 0, 1000);
            }
            System.out.println("Source file found, preparing to copy. File copied successfuly");
        }catch(IOException e) {
            System.out.println("No such file is found");
        }finally {
            /*
            if(fin != null || fout != null) {
                try {
                    fin.close();
                    fout.close();
                } catch (IOException e) {
                    System.out.println("Something went wrong....");
                }
            }
            */
            if(fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    System.out.println("Error in closing the file"+fin.toString());
                }
                
            }
            if(fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    System.out.println("Error in closing the file "+fout.toString());
                }
                
            }
        }
        
    }
}
