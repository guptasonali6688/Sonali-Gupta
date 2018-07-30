package com.zycus.threadAssignment3;

import java.util.Stack;

public class Consumer implements Runnable{

    Stack<String> stack;

    //Constructor
    public Consumer(Stack<String> stack) {
        super();
        this.stack = stack;
    }

    @Override
    public void run() {
        synchronized(stack) {
            if(stack.isEmpty()) {
                System.out.println("Stack is empty. Consumer can't remove");    
                try {                    
                    stack.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                for(int i=100; i>=1 ; --i) {
                    System.out.println("out "+i+" "+stack.pop());
                }    
                stack.notify();
            }
        }
    }

}
