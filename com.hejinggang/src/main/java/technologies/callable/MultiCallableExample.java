package technologies.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiCallableExample {

    public static void main(String []args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks = Arrays.asList(
                () -> 1,
                () -> 2,
                () -> 3
                );

        List<Future<Integer>> futures = executorService.invokeAll(tasks);

        for (Future<Integer> future: futures) {
            System.out.println(future.get());
        }
    }
}
