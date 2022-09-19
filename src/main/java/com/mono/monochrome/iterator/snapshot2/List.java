package com.mono.monochrome.iterator.snapshot2;

import java.util.Iterator;

/**
 * @author monochrome
 * @date 2022/9/19
 */
public interface List<E> {
    void add(E obj);

    void remove(E obj);

    Iterator<E> iterator();
}
