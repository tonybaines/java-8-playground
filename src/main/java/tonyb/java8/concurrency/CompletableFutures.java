package tonyb.java8.concurrency;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("ALL")
public class CompletableFutures {
    public static void main(String[] args) {

        CompletableFuture<Integer> answer = CompletableFuture.supplyAsync(() -> 42);
        CompletableFuture<String> promise = new CompletableFuture<>();

        CompletableFuture<String> declamedAnswer =
                answer.thenApplyAsync(x -> "The answer, the ultimate answer, to Life, the Universe and Everything? " + x + "!");

        declamedAnswer.whenComplete( (qAndA, error) -> {
            if (qAndA != null){
                System.out.println(qAndA);
            }
            else {
                System.err.println(error.getMessage());
            }
        });


    }
}
