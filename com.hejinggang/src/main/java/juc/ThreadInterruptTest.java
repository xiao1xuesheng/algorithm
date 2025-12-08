package juc;

public class ThreadInterruptTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread was interrupted, stopping execution.");
                    return;
                }
                System.out.println("Thread 1 - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread sleep interrupted, stopping execution.");
                    return;
                }
            }
        });
        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread interrupting Thread 1");
        t1.interrupt();
    }
}
