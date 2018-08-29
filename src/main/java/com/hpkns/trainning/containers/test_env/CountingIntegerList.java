package com.hpkns.trainning.containers.test_env;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {
  private final int size;
  public CountingIntegerList(int size) {
    this.size = size < 0 ? 0 : size;
  }
  @Override
  public Integer get(int index) {
    return Integer.valueOf(index);
  }
  @Override
  public int size() {
    return size;
  }
}
