package com.csp.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/4/17
 */
public abstract class Stack<E> {

    public abstract void push(E e);

    public void pushAll(Collection<? extends E> iterable) {
        for (E e : iterable) {
            push(e);
        }
    }

    public abstract E pop();

    public void popAll(Collection<? super E> collection) {
        while (!isEmpty()) {
         collection.add(pop());
        }
    }

    public abstract boolean isEmpty();

    private static class Deque<E> extends Stack<E> {

        @Override
        public void push(E e) {

        }

        @Override
        public E pop() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }

    public static void main(String[] args) {
//        Stack<Number> stack = new Deque<>();
//        Collection<Integer> collection1 = new ArrayList<>();
//        stack.pushAll(collection1);
//
//        Stack<Number> stack2 = new Deque<>();
//        Collection<Number> collection2 = new ArrayList<>();
//        stack2.popAll(collection2);

        List<Integer> src = new ArrayList<>();
        src.add(2);
        List<Number> dest = new ArrayList<>();
        dest.add(1D);
        Collections.copy(dest, src);
        System.out.println();

        List<Object> list = new ArrayList<>(5);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        Collections.fill(list, "2D");
        System.out.println(list);
    }

}
