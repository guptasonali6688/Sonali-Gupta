package com.zycus.threadAssignment3;

import java.util.Stack;

public class App {
    
    public static void main(String[] args) {
      Stack<String> stack = new Stack<>();
    
      Thread t1 = new Thread(new Producer(stack));
      Thread t2 = new Thread(new Consumer(stack));
      Thread t3 = new Thread(new Producer(stack));
      Thread t4 = new Thread(new Consumer(stack));
      t1.start();
      t3.start();
      t2.start();
      t4.start();
    }
}

