package ru.tedBilgar.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainStreamLesson {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1
        System.out.println(
                transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList())
        );
        //2
        System.out.println(
                transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().count()
        );
        //3
        System.out.println(
                transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).map(Transaction::getTrader).sorted(Comparator.comparing(Trader::getName))
        );
        //5
        System.out.println(
                transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Milan")).map(Transaction::getTrader)
        );
        //6
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue)
                .forEach(System.out::println);
        



    }
}
