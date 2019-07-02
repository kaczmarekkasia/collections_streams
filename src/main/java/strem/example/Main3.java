package strem.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main3 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("a", "b", "c", "ad"));

//        Predicate<String> predicateStartsWithA = stringElement -> {
//            return stringElement.startsWith("a");
//        };
        Predicate<String> predicateStartsWithA = stringElement -> stringElement.startsWith("a");

//        Consumer<String> printConsumer = consumerStringElement -> {
//            System.out.println(consumerStringElement);
//        };
        Consumer<String> printConsumer = consumerStringElement -> System.out.println(consumerStringElement);

        stringList.stream()
                .filter(predicateStartsWithA)
                .forEach(printConsumer);


    }
}