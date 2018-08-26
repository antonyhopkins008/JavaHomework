package com.hpkns.trainning.containers;

public class LinkedStack<T> {
  private static class Node<T> {
    T item;
    Node<T> next;
    Node() {
      item = null;
      next = null;
    }
    Node(T item, Node<T> current) {
      this.item = item;
      this.next = current;
    }
    boolean end() {return item == null && next == null;}
  }

  Node<T> top = new Node<>();//sentinel
  public void push(T item) {
    top = new Node<T>(item, top);
  }
  public T pop() {
    T result = top.item;
    if (!top.end()) {
      top = top.next;
    }
    return result;
  }
  public static void main(String[] args) {
    LinkedStack<String> linkedList = new LinkedStack<>();
    for(String s: "Pr on the top".split(" ")){
      linkedList.push(s);
    }
    String s;
    while ((s = linkedList.pop()) != null) {
      System.out.println(s);
    }
  }
}
