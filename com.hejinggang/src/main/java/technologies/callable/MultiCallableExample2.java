package technologies.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiCallableExample2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 将所有 Future 放入列表
        List<CompletableFuture<Integer>> futures = Arrays.asList(
                CompletableFuture.supplyAsync(() -> 100, executor),
                CompletableFuture.supplyAsync(() -> 200, executor),
                CompletableFuture.supplyAsync(() -> 300, executor)
        );

        // 使用循环处理所有 Future
        futures.forEach(future -> future.thenAccept(System.out::println));

        executor.shutdown();
    }
}
