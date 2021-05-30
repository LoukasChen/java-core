package com.csp.baseClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/03/12
 */
public class RandomDemo {

    public static void main(String[] args) {
        System.out.println(new Random().nextInt());

        Pair[] pairs = new Pair[]{new Pair("A", 70), new Pair("B", 20), new Pair("C", 10)};
        Map<String, Integer> map = new HashMap<>();
        WeightRandom weightRandom = new WeightRandom(pairs);
        for (int i = 0; i < 500; i++) {
            Object item = weightRandom.nextItem();
            int value = map.getOrDefault(item, 0);
            map.put((String) item, ++value);
        }
//        System.out.println(map.toString());
    }

}
