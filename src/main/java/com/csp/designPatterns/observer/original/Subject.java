package com.csp.designPatterns.observer.original;

/**
 * @author csp
 * @description: 主题
 * @date 2019/8/26 22:46
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
