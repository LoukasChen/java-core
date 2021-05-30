package com.csp.java8.lambda.ChainOfResponsibilityPattern;

/**
 * @description: 责任链模式
 * @author: csp52872
 * @date: 2021/03/28
 */
public abstract class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T t = handleWork(input);
        if (successor != null) {
            return successor.handle(t);
        }
        return t;
    }

    abstract protected T handleWork(T input);

}

class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    public String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

}

class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    public String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }

}
