package com.zycus.threadAssignment3;

import java.util.Random;
import java.util.Stack;

public class Producer implements Runnable{

    Stack<String> stack;

    public Producer(Stack<String> stack) {
        super();
        this.stack = stack;
    }

    @Override
    public void run() {
        synchronized(stack) {
            if(stack.size() == 100) {
                System.out.println("Stack is full. Producer can't add more");
                try {                    
                    stack.wait();                
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                    for(int i=1; i<=100; ++i) {            
                    Random random = new Random();
                    String output = random.toString().substring(17, random.toString().length());
                    System.out.println("in "+i+ " "+stack.push(output));
                }
                stack.notify();
            }
        }        
    }

}

