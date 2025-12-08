package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 方法一：继承Thread类
//        MyJob job1 = new MyJob();
//        job1.start();
        // 方法二：实现Runnable接口
//        MyRunnable runnable = new MyRunnable();
//        Thread job2 = new Thread(runnable);
//        job2.start();
        // 方法三：使用Lambda表达式
//        Thread job3 = new Thread(() -> {
//            for (int i=0; i<5; i++) {
//                System.out.println("lambda thread is running:" + i);
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        job3.start();
        // 方法四：使用匿名内部类
//        Thread job4 = new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("anonymous thread is running: " + i);
//                    try {
//                        Thread.sleep(250); // Sleep for 250 milliseconds
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        job4.start();
        // 使用Callable和FutureTask 测试带有返回值的多线程
        Callable<Integer> callableTask = new Callable() {
            @Override
            public Integer call() throws Exception {
                int count = 0;
                for (int i=0; i<100; i++) {
                    System.out.println("Callable thread is running: " + i);
                    count += i;
                    try {
                        Thread.sleep(10); // Sleep for 150 milliseconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return count;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callableTask);
        Thread callableThread = new Thread(futureTask);
        callableThread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread is running: " + i);
            try {
                Thread.sleep(300); // Sleep for 300 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(futureTask.get());
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable thread is running: " + i);
            try {
                Thread.sleep(400); // Sleep for 400 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyJob extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + this.getName() + " is running: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
