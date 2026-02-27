package technologies.threadlocaltest;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();


    public static void main(String[] args) {
        ExecutorService rawExecutor = Executors.newFixedThreadPool(2);
        ExecutorService executor = TtlExecutors.getTtlExecutorService(rawExecutor);
        executor.submit(() -> {
            System.out.println("hahhaha");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executor.submit(() -> {
            System.out.println("hahhaha");
        });
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.threadLocal.set("thread local value");
        threadLocalTest.inheritableThreadLocal.set("inheritable thread local value");
        threadLocalTest.transmittableThreadLocal.set("transmittable thread local value");

        new Thread(() -> {
            System.out.println("thread local value : " + threadLocalTest.threadLocal.get());
            System.out.println("inheritable thread local value : " + threadLocalTest.inheritableThreadLocal.get());
            System.out.println("transmittable thread local value : " + threadLocalTest.transmittableThreadLocal.get());
        }).start();

        executor.submit(() -> {
            System.out.println("thread local value : " + threadLocalTest.threadLocal.get());
            System.out.println("inheritable thread local value : " + threadLocalTest.inheritableThreadLocal.get());
            System.out.println("transmittable thread local value : " + threadLocalTest.transmittableThreadLocal.get());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("================================");

        executor.submit(() -> {
            System.out.println("thread local value : " + threadLocalTest.threadLocal.get());
            System.out.println("inheritable thread local value : " + threadLocalTest.inheritableThreadLocal.get());
            System.out.println("transmittable thread local value : " + threadLocalTest.transmittableThreadLocal.get());
        });

        executor.shutdown();
    }
}
