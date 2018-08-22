package com.hpkns.trainning.containers.list_functionality;

import java.util.*;

public class Lists {
  private static boolean b;
  private static String s;
  private static int i;
  private static Iterator<String> iterator;
  private static ListIterator<String> listIterator;
  public static void basicTest(List<String> a) {
    //Add to position 1
    a.add(1, "x");
    //Add to end
    a.add("x");
    a.addAll(3, Countries.names(20));
    //Is value exists
    b = a.contains("1");
    b = a.containsAll(Countries.names(20));
    //Random access for ArrayList - faster, for LinkedList - slower
    //Get element at position 1
    s = a.get(1);
    //Get index of object
    i = a.indexOf("1");
    //Checks whether list is empty
    b = a.isEmpty();
    //Simple iterator
    iterator = a.iterator();
    //List iterator
    listIterator = a.listIterator();
    //Iterator from 3 element
    iterator = a.listIterator(3);
    i = a.lastIndexOf("1");
    //Remove from position 1
    a.remove(1);
    //Remove object
    a.remove("3");
    //Write "y" to position 1
    a.set(1, "y");
    //Intersection of dimensions
    a.retainAll(Countries.names());
    //Remove all elements existing in argument
    a.removeAll(Countries.names(25));
    //Get size
    i = a.size();
    //Remove all elements
    a.clear();
  }
  public static void iterMotion(List<String> a) {
    ListIterator<String> it = a.listIterator();
    b = it.hasNext();
    b = it.hasPrevious();
    s = it.next();
    i = it.nextIndex();
    s = it.previous();
    i = it.previousIndex();
  }
  public static void iterManipulator(List<String> a) {
    ListIterator<String> it = a.listIterator();
    it.add("47");
    //Go next element after "add()"
    it.next();
    //Remove element after just created
    it.remove();
    //Go next element after "remove()"
    it.next();
    //Change element after removed
    it.set("47");
  }
  public static void testVisual(List<String> a) {
    System.out.println("****** testVisual begin ******");
    System.out.println(a);
    List<String> b = Countries.names(25);
    System.out.println("b = " + b);
    a.addAll(b);
    a.addAll(b);
    System.out.println(a);
    //Insert, remove, change element using ListIterator
    ListIterator<String> x = a.listIterator(a.size() / 2);
    x.add("one");
    System.out.println(a);
    System.out.println(x.next());
    x.remove();
    System.out.println(x.next());
    x.set("47");
    System.out.println(a);
    //Go through list in back direction
    x = a.listIterator(a.size());
    while (x.hasPrevious()) {
      System.out.print(x.previous() + " ");
    }
    System.out.println();
    System.out.println("****** testVisual finish ******");
  }
  //Some operations supported only for LinkedList
  public static void testLinkedList() {
    System.out.println("****** testLinkedList begin ******");
    LinkedList<String> ll = new LinkedList<>();
    ll.addAll(Countries.names(25));
    System.out.println(ll);
    //Interpret as stack - adding
    ll.addFirst("one");
    ll.addFirst("two");
    System.out.println(ll);
    //Reading from top stack without removing
    System.out.println(ll.getFirst());
    //Analog getting from stack
    System.out.println(ll.removeFirst());
    System.out.println(ll.removeFirst());
    //Interpret as queue with removing element from end
    System.out.println(ll.removeLast());
    System.out.println(ll);
    System.out.println("****** testLinkedList end ******");
  }
  public static void main(String[] args) {
    basicTest(new LinkedList<String>(Countries.names(25)));
    basicTest(new ArrayList<String>(Countries.names(25)));
    iterMotion(new LinkedList<>(Countries.names(25)));
    iterMotion(new ArrayList<>(Countries.names(25)));
    iterManipulator(new LinkedList<>(Countries.names(25)));
    iterManipulator(new ArrayList<>(Countries.names(25)));
    testVisual(new LinkedList<>(Countries.names(25)));
    testLinkedList();
  }
}
