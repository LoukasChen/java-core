package com.csp.design_patterns.singleton;

/**
 * @author csp
 * @description: TODO
 * @date 2019/8/26 22:46
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
