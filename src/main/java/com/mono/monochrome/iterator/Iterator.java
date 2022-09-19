package com.mono.monochrome.iterator;

/**
 * @author monochrome
 * @date 2022/9/19
 */
public interface Iterator<E> {
  boolean hasNext();
  void next();
  E currentItem();
}