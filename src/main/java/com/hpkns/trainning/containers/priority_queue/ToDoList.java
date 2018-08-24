package com.hpkns.trainning.containers.priority_queue;

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
  public static class ToDoItem implements Comparable<ToDoItem> {
    private char primary;
    private int secondary;
    private String item;
    public ToDoItem(char primary, int secondary, String item) {
      this.primary = primary;
      this.secondary = secondary;
      this.item = item;
    }
    @Override
    public int compareTo(ToDoItem item) {
      if (primary > item.primary) {
        return +1;
      }
      if (secondary == item.secondary) {
        return 0;
      }
      return -1;
    }
    @Override
    public String toString() {
      return Character.toString(primary) + secondary + ": " + item;
    }
  }
  private void add(String str, char c, int i) {
    super.add(new ToDoItem(c, i, str));
  }
  public static void main(String[] args) {
    ToDoList list = new ToDoList();
    list.add("Empty trash", 'C', 4);
    list.add("Foo", 'A', 2);
    list.add("Bar", 'B', 1);
    list.add("Hello", 'D', 3);
    while (!list.isEmpty()) {
      System.out.println(list.remove());
    }
  }
}
