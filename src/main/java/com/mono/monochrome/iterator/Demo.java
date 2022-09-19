package com.mono.monochrome.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author monochrome
 * @date 2022/9/19
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        ArrayIterator<Integer> integerArrayIterator = new ArrayIterator<>(arrayList);
        while (integerArrayIterator.hasNext()) {
            System.out.println(integerArrayIterator.currentItem());
            integerArrayIterator.next();
        }
    }

}
