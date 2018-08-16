package com.hpkns.trainning.containers.map_data;

import utils.Generator;

import java.util.Iterator;

public class Letters implements Generator<Pair<Integer, String>>,
        Iterable<Integer> {
  private int index = 1;
  private int size = 9;
  private char letter = 'A';
  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      @Override
      public boolean hasNext() {
        return index < size;
      }
      @Override
      public Integer next() {
        return index++;
      }
    };
  }
  @Override
  public Pair<Integer, String> next() {
    return new Pair<Integer, String>(index++, "" + letter++);
  }
}
