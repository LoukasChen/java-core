package com.csp.java8.lambda.ChainOfResponsibilityPattern;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/03/28
 */
public class HandlerObject {

    public static void main(String[] args) {
//        ProcessingObject<String> headerTextProcessing = new HeaderTextProcessing();
//        ProcessingObject<String> spellCheckerProcessing = new SpellCheckerProcessing();
//        headerTextProcessing.setSuccessor(spellCheckerProcessing);
//        System.out.println(headerTextProcessing.handle("Aren't labdas really sexy?!!"));

        UnaryOperator<String> headerTextProcessing = text -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = text -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerTextProcessing.andThen(spellCheckerProcessing);
        System.out.println(pipeline.apply("Aren't labdas really sexy?!!"));
    }
}
