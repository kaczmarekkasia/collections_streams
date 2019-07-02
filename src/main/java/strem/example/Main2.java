package strem.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main2 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("a", "b", "c", "ad"));

//        Predicate<String> predicateStartsWithA = new Predicate<String>() {
//            @Override
//            public boolean test(String stringElement) {
//                return stringElement.startsWith("a");
//            }
//        };

        Predicate<String> predicateStartsWithA = stringElement -> {
            return stringElement.startsWith("a");
        };

//        Consumer<String> printConsumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
        Consumer<String> printConsumer = consumerStringElement -> {
            System.out.println(consumerStringElement);
        };

        stringList.stream()
                .filter(predicateStartsWithA)
                .forEach(printConsumer);


    }
}