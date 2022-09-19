package com.mono.monochrome.iterator.snapshot1;

import java.util.Iterator;

/**
 * @author monochrome
 * @date 2022/9/19
 */
public class Demo {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(8);
        list.add(2);

        Iterator<Integer> iter1 = list.iterator();//snapshot: 3, 8, 2
        list.remove(2);//list：3, 8
        Iterator<Integer> iter2 = list.iterator();//snapshot: 3, 8
        list.remove(3);//list：8
        Iterator<Integer> iter3 = list.iterator();//snapshot: 3

        // 输出结果：3 8 2
        while (iter1.hasNext()) {
            System.out.print(iter1.next() + " ");
        }
        System.out.println();

        // 输出结果：3 8
        while (iter2.hasNext()) {
            System.out.print(iter2.next() + " ");
        }
        System.out.println();

        // 输出结果：8
        while (iter3.hasNext()) {
            System.out.print(iter3.next() + " ");
        }
        System.out.println();
    }

}
