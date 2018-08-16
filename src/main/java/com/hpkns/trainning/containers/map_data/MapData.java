package com.hpkns.trainning.containers.map_data;

import utils.Generator;

import java.util.LinkedHashMap;

public class MapData<K, V> extends LinkedHashMap<K, V> {
  MapData(Generator<Pair<K, V>> generator, int quantity) {
    for (int i = 0; i < quantity; i++) {
      Pair<K, V> pair = generator.next();
      put(pair.key, pair.value);
    }
  }
  MapData(Generator<K> genKey, Generator<V> genValue, int quantity) {
    for (int i = 0; i < quantity; i++) {
      put(genKey.next(), genValue.next());
    }
  }
  MapData(Generator<K> genKey, V value, int quantity) {
    for (int i = 0; i < quantity; i++) {
      put(genKey.next(), value);
    }
  }
  MapData(Iterable<K> genKey, Generator<V> genValue) {
    for (K key : genKey) {
      put(key, genValue.next());
    }
  }
  MapData(Iterable<K> genKey, V value) {
    for (K key : genKey) {
      put(key, value);
    }
  }
  public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> generator,
                                         int quantity) {
    return new MapData<K, V>(generator, quantity);
  }
  public static <K, V> MapData<K, V> map(Generator<K> genKey,
                                         Generator<V> genValue,
                                         int quantity) {
    return new MapData<K, V>(genKey, genValue, quantity);
  }
  public static <K, V> MapData<K, V> map(Iterable<K> genKey,
                                         Generator<V> genValue) {
    return new MapData<K, V>(genKey, genValue);
  }
  public static <K, V> MapData<K, V> map(Iterable<K> genKey, V value) {
    return new MapData<K, V>(genKey, value);
  }
}
