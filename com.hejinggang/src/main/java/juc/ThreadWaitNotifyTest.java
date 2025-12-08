package juc;

// wait notify 需要都在Synchronized中使用，否则会报IllegalMonitorStateException异常
// 会产生两个池，一个是等待池，一个是锁池，当调用wait()时，线程会释放锁并进入等待池，
// 直到被notify()或notifyAll()唤醒，才会重新竞争锁，进入锁池
public class ThreadWaitNotifyTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (ThreadWaitNotifyTest.class) {
                for (int i=0; i<5; i++) {
                    if (i == 2) {
                        try {
                            ThreadWaitNotifyTest.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " - Count: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {

                for (int i=0; i<8; i++) {
                    if (i == 4) {
                        synchronized (ThreadWaitNotifyTest.class) {
                            ThreadWaitNotifyTest.class.notifyAll();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " - Count: " + i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
