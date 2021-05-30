package com.csp.java8.lambda.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: csp52872
 * @date: 2021/03/28
 */
public interface Subject {

    void registerObserver(Observer observer);

    void notifyObservers(String tweet);
}

class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(observer -> observer.notify(tweet));
    }

    public static void main(String[] args) {
        Feed feed = new Feed();
//        feed.registerObserver(new NYTimes());
//        feed.registerObserver(new Guardian());
//        feed.registerObserver(new LeMonde());
//        feed.notifyObservers("The queen said her favourite book is Java 8 in Action!");


        feed.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        feed.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });
        feed.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        });

        feed.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
