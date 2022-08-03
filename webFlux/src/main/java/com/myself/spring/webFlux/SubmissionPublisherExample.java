package com.myself.spring.webFlux;

import java.util.concurrent.SubmissionPublisher;

public class SubmissionPublisherExample {
    public static void main(String... args) throws InterruptedException {
        //消息发布者
        SubmissionPublisher publisher = new SubmissionPublisher<>();
        //用户  订阅  消息发布者
        publisher.subscribe(new PrintSubscriber());

        System.out.println("Submitting items...");

        for (int i = 0; i < 10; i++) {
            //消息方法者发布消息
            publisher.submit(i);

        }

        Thread.sleep(1000);

        publisher.close();

    }
}
