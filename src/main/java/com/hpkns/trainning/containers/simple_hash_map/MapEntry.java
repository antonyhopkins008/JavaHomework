package com.hpkns.trainning.containers.simple_hash_map;

import java.util.Map;
import java.util.Objects;

public class MapEntry<K, V> implements Map.Entry<K, V> {
  private K key;
  private V value;
  public MapEntry(K key, V value) {
    this.key = key;
    this.value = value;
  }
  @Override
  public K getKey() {
    return key;
  }
  @Override
  public V getValue() {
    return value;
  }
  @Override
  public V setValue(V value) {
    V result = this.value;
    this.value = value;
    return result;
  }
  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }
  @Override
  public String toString() {
    return key + "=" + value;
  }
}
