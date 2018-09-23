package com.hpkns.trainning.chain;

import java.util.Random;

class Enums {
  private static Random random = new Random(47);
  public static <T extends Enum<T>> T random(Class<T> ec) {
    return random(ec.getEnumConstants());
  }
  public static <T> T random(T[] values) {
    return values[random.nextInt(values.length)];
  }
}
