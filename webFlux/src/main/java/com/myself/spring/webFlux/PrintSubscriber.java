package com.myself.spring.webFlux;

import java.util.concurrent.Flow;

public class PrintSubscriber implements Flow.Subscriber<Integer> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println("onSubscribe");
        //subscription对象是标识着订阅者和发表者之间的订阅关系
        subscription.request(1);
        //subscription.cancel();
    }



    public void onNext(Integer item) {
        System.out.println("Received item: " + item);
        //订阅者在每一次接收到消息之后，都要设定一下订阅关系，是取消还是继续订阅
        //subscription.request(1);
        //subscription.cancel();
    }

    @Override
    public void onError(Throwable error) {
        System.out.println("Error occurred: " + error.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("PrintSubscriber is complete");
    }

}
