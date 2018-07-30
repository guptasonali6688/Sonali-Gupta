package com.zycus.threadAssignment1;

import java.io.*;

public class TestFileCopy {

        public static void main(String[] args) throws IOException{
        
        String sourceFile = "D:/source/Desert.jpg";
        String destinationFile = "D:/destination/Desert.jpg";
        
        //FileCopy file = new FileCopy(sourceFile, destinationFile);
        new Thread(new FileCopy(sourceFile, destinationFile)).start();;
    }

}


