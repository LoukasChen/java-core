package com.csp.baseClass;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/03/12
 */
public class WeightRandom {

    private Pair[] pairs;

    private double[] arrays;

    private Random random;

    public WeightRandom(Pair[] pairs) {
        this.pairs = pairs;
        this.random = new Random();
        prepare();
    }

    private void prepare() {
        int weight = 0;
        for (Pair pair : pairs) {
            weight += pair.getWeight();
        }

        arrays = new double[pairs.length];
        int sum = 0;
        for (int i = 0; i < pairs.length; i++) {
            sum += pairs[i].getWeight();
            arrays[i] = sum / (double) weight;
        }
    }

    public Object nextItem() {
        double randomValue = random.nextDouble();
        int index = Arrays.binarySearch(arrays, randomValue);
        if (index < 0) {
            index = -index - 1;
        }
        return pairs[index].getItem();
    }
}
