package com.mono.monochrome.guava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author monochrome
 * @date 2022/10/13
 */
public class ImmutableDemo {

    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("a");
        originalList.add("b");
        originalList.add("c");
        List<String> unmodifiableList = Collections.unmodifiableList(originalList);
        ImmutableList<String> immutableList = ImmutableList.copyOf(originalList);
        // jdkUnmodifiableList.add("d"); // 抛出UnsupportedOperationException
        // guavaImmutableList.add("d"); // 抛出UnsupportedOperationException
        originalList.add("d");
        print(originalList); // a b c d
        print(unmodifiableList); // a b c d
        print(immutableList); // a b c
    }

    private static void print(List<String> list) {
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
