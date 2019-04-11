package com.liufei.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author:liufei
 * @create_time:2019/3/21-14:52
 */
public class StreamArrayList {

    public static void main(String[] args) {
        concurrentFun();
    }
    public static void collectFun_syn() {
        List<Integer> listOfIntegers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            listOfIntegers.add(i);
        }

        List<Integer> parallelStorage = listOfIntegers
                .parallelStream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());


        System.out.println();

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));

        System.out.println();
        System.out.println("Sleep 5 sec");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
    }

    public static void concurrentFun() {
        List<Integer> listOfIntegers =
                new ArrayList<>();
        for (int i = 0; i <100; i++) {
            listOfIntegers.add(i);
        }
        List<Integer> parallelStorage = new ArrayList<>() ;
        listOfIntegers
                .parallelStream()
                .filter(i->i%2==0)
                .forEach(i->parallelStorage.add(i));
        System.out.println();

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));

        System.out.println();
        System.out.println("Sleep 5 sec");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
    }
}
