package juc;

public class ThreadStateTest {

    public static void main(String []args) {

        // NEW
//        Thread t1 = new Thread(() -> {
//
//        });

        // RUNNABLE
//        Thread t1 = new Thread(() -> {
//            while (true) {
//
//            }
//        });
//        t1.start();

        // BLOCKED
//        Object lock = new Object();
//        Thread t1 = new Thread(() -> {
//            synchronized (lock) {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        synchronized (lock) {
//            t1.start();
//            try {
//                // 确保t1线程先获取锁
//                Thread.sleep(100);
//                System.out.println(t1.getState());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        // TIMED_WAITING
//        Thread t1 = new Thread(() -> {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t1.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // WAITING
//        Object lock = new Object();
//        Thread t1 = new Thread(() -> {
//            synchronized (lock) {
//                try {
//                    lock.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(t1.getState());

        // TERMINATED
        Thread t1 = new Thread(() -> {
            System.out.println("Thread is running");
        });
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());
    }
}
