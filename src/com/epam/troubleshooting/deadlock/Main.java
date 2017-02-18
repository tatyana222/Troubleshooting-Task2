package com.epam.troubleshooting.deadlock;


public class Main {

    private final static Object resource1 = new Object();
    private final static Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1 is locking resource 1");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (resource2) {
                        System.out.println("Thread 1 is locking resource 2");
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2 is locking resource 2");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (resource1) {
                        System.out.println("Thread 2 is locking resource 1");
                    }
                }
            }
        };

        Thread thread3 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 3 is locking resource 1");
                }
            }
        };

        Thread thread4 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 4 is locking resource 1");
                }
            }
        };

        Thread thread5 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 5 is locking resource 1");
                }
            }
        };

        Thread thread6 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 6 is locking resource 2");
                }
            }
        };

        Thread thread7 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 7 is locking resource 2");
                }
            }
        };

        Thread thread8 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 8 is locking resource 2");
                }
            }
        };

        thread1.start();
        thread2.start();

        thread3.start();
        thread4.start();
        thread5.start();

        thread6.start();
        thread7.start();
        thread8.start();
    }
}
