package async;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureOperations {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //SupplyAsync accept a return statement
        CompletableFuture<String> request1 = CompletableFuture.supplyAsync(() -> {
            return makeApiRequest();
        });

        CompletableFuture<String> request2 = CompletableFuture.supplyAsync(() -> {
            return makeApiRequest();
        });

        CompletableFuture<String> request3 = CompletableFuture.supplyAsync(() -> {
            return makeApiRequest();
        });

        CompletableFuture<String> request4 = CompletableFuture.supplyAsync(() -> {
            return makeApiRequest();
        });

        CompletableFuture<String> request5 = CompletableFuture.supplyAsync(() -> {
            return makeApiRequest();
        });

        CompletableFuture<String> request6 = CompletableFuture.supplyAsync(() -> {
            return makeApiRequest();
        });

        CompletableFuture.allOf(request1, request2, request3, request4, request5, request6)
                .thenRun(() -> {
                    try {
                        System.out.println("response 1: " + request1.get());
                        System.out.println("response 2: " + request2.get());
                        System.out.println("response 3: " + request3.get());
                        System.out.println("response 4: " + request4.get());
                        System.out.println("response 5: " + request5.get());
                        System.out.println("response 6: " + request6.get());
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }

                }).get();

        //then combine execute 2 requisitions in parallel
//        request1.thenCombine(request2, (response1, response2) -> {
//            System.out.println("Requisition 1: " + response1);
//            System.out.println("Requisition 2: " + response2);
//            return "complete";
//        }).get();


        //Run async just make the request, don't return nothing
//        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
//            makeApiRequest();
//        });
//        for(int i = 0; i < 100; i++){
//            System.out.println("Testing");
//            Thread.sleep(100);
//        }
//
//        completableFuture.get();
//
//        System.out.println("Here just when the get() return");
    }

    public static String makeApiRequest(){
        try{
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dog.ceo/api/breeds/image/random"))
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: " + response.statusCode());
            return response.body();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }
}
