package com.hpkns.trainning.arrays;

interface Generator<T> {
  public T next();
}

public class CountingGenerator {
  //**Boolean generator**
  public static class Boolean implements Generator<java.lang.Boolean> {
    private boolean value = false;
    @Override
    public java.lang.Boolean next() {
      return value;
    }
  }
  //**Byte generator**
  public static class Byte implements Generator<java.lang.Byte> {
    private byte value = 0;
    @Override
    public java.lang.Byte next() {
      return value++;
    }
  }
  //**Character generator**
  static char[] chars = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
  public static class Character implements Generator<java.lang.Character> {
    int index = -1;
    @Override
    public java.lang.Character next() {
      index = (index + 1) % chars.length;
      return chars[index];
    }
  }
  //**String generator**
  public static class String implements Generator<java.lang.String> {
    private int length = 7;
    Generator<java.lang.Character> chGen = new Character();
    @Override
    public java.lang.String next() {
      char[] buff = new char[length];
      for (int i = 0; i < length; i++) {
        buff[i] = chGen.next();
      }
      return new java.lang.String(buff);
    }
  }
  //**Short generator**
  public static class Short implements Generator<java.lang.Short> {
    private short value = 0;
    @Override
    public java.lang.Short next() {
      return value++;
    }
  }
  //**Integer generator**
  public static class Integer implements Generator<java.lang.Integer> {
    private int value = 0;
    @Override
    public java.lang.Integer next() {
      return value++;
    }
  }
  //**Long generator**
  public static class Long implements Generator<java.lang.Long> {
    private long value = 0;
    @Override
    public java.lang.Long next() {
      return value++;
    }
  }
  //**Float generator**
  public static class Float implements Generator<java.lang.Float> {
    private float value = 0;
    @Override
    public java.lang.Float next() {
      return value += 0.1;
    }
  }
  //**Double generator**
  public static class Double implements Generator<java.lang.Double> {
    private double value = 0.0;
    @Override
    public java.lang.Double next() {
      return value += 0.1;
    }
  }
}



