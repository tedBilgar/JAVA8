package ru.tedBilgar.lambdas;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas {

    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 5;


        System.out.println(predicate.test(4));

        Function<Integer, String> function = x -> x > 5 ? "Success" : "False";

        function.apply(5);



    }
}


