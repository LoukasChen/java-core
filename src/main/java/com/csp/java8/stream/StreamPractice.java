package com.csp.java8.stream;

import com.csp.java8.object.Trader;
import com.csp.java8.object.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: csp52872
 * @date: 2021/02/13
 */
public class StreamPractice {

    private static List<Transaction> transactions = null;

    static {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    public static void main(String[] args) {
        System.out.println(transaction());

        System.out.println(traderDistinctCity());

        System.out.println(filterTraderOrderByName());

        System.out.println(traderNameStrOrderByAlphabet());

        System.out.println(traderCity());

        traderMoney();

        System.out.println(maxtransactionsMoney().get());

        System.out.println(minTransaction().get());
    }

    /**
     * 找出2011年发生的所有交易，并按交易额排序(从低到高)
     *
     * @return
     */
    public static List<Transaction> transaction() {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
    }

    /**
     * 交易员都在哪些不同的城市工作过
     *
     * @return
     */
    public static List<String> traderDistinctCity() {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        //或者采用set去重
//        Set<String> set = transactions.stream()
//                .map(transaction -> transaction.getTrader().getCity())
//                .collect(Collectors.toSet());
    }

    /**
     * 查找所有来自于剑桥的交易员，并按姓名排序
     *
     * @return
     */
    public static List<Trader> filterTraderOrderByName() {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    /**
     * 返回所有交易员的姓名字符串，按字母顺序排序
     */
    public static String traderNameStrOrderByAlphabet() {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (i, j) -> i + j);
    }

    /**
     * 有没有交易员是在米兰工作的
     */
    public static boolean traderCity() {
        return transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
    }

    /**
     * 打印生活在剑桥的交易员的所有交易额
     */
    public static void traderMoney() {
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    /**
     * 所有交易中，最高的交易额是多少
     *
     * @return
     */
    public static Optional<Integer> maxtransactionsMoney() {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
    }

    /**
     * 找到交易额最小的交易
     */
    public static Optional<Transaction> minTransaction() {
        Optional<Transaction> minTransaction = transactions.stream()
                .reduce((i, j) -> i.getValue() < j.getValue() ? i : j);

        // 更简洁的写法利用min函数
        return transactions.stream().min(Comparator.comparing(Transaction::getValue));
    }

}
