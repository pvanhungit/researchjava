package org.example;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testcompletefuture {

    public static void main(String[] args) throws  Exception {
        Future<String> completableFuture = calculateAsync();

// ...

        String result = completableFuture.get();

        System.out.println(result);
        assertEquals("Hello", result);
    }

    public static Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }
}
