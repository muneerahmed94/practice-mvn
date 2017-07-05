package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Muneer on 20-04-2017.
 */
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 1; i <= 10; i++) {
            System.out.println("Slide: " + i);
            Thread.sleep(1000);
        }
    }
}

class MyThread extends Thread {
    static Thread mainThread;
    @Override
    public void run() {
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < 10; i++) {
            System.out.println("Child thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable implements Runnable {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Child thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class X {
    synchronized void m1() {}
    synchronized void m2() {}
    void m3() {}
}