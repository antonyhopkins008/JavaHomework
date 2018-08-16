package com.hpkns.trainning.containers.map_data;

import com.hpkns.trainning.arrays.CountingGenerator;
import com.hpkns.trainning.arrays.RandomGenerator;

public class MapDataTest {
  public static void main(String[] args) {
    System.out.println(MapData.map(new CountingGenerator.Character(),
                                   new RandomGenerator.String(), 10));

    System.out.println(MapData.map(new Letters(), 10));

    System.out.println(
            MapData.map(new Letters(), new RandomGenerator.String()));

    System.out.println(MapData.map(new Letters(), "Boo"));
  }
}
