package juc;

public class ThreadJoinTest {

    public static void main(String []args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 - Count: " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        for (int j = 0; j < 5; j++) {
            try {
                if (j == 2) {
                    t1.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main Thread - Count: " + j);
        }
    }
}
