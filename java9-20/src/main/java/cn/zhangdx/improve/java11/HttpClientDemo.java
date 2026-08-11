package cn.zhangdx.improve.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * 内置HttpClient使用示例
 * @author zhangdx
 * @date 2026/8/11 15:35
 */
public class HttpClientDemo {

    public static void main(String[] args) {
        var isAsync = true;
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("http://www.baidu.com")).build();
            if (isAsync) {
                CompletableFuture<Void> future = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body).thenAccept(body -> System.out.println("async response is: " + body));
                future.get();
            } else {
                String body = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
                System.out.println("response is: " + body);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
