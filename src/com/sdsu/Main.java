package com.sdsu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Heap heap = new Heap();
    HeapNode heapNode = new HeapNode();
    InOrder inOrder = new InOrder();

    int maxNodes;
    int newValue;
    String heapType;
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n HeapType (minheap or maxheap) : ");
    heapType = scanner.nextLine();
    heap.setOrdering(heapType);

    System.out.print("\n Enter number of nodes you want to insert into the Heap :\n");
    maxNodes = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < maxNodes; i++) {
      System.out.print(" Enter the next node: ");
      newValue = Integer.parseInt(scanner.nextLine());
      heapNode.setValue(newValue);
      heap.add(heapNode);
    }

    System.out.print("\n Post Order of all nodes of the heap\n");
    heap.treeTraversal(heap.getHead());
    Object[] heapArray = heap.toArray();
    System.out.print("toArray : ");
    for (Object obj : heapArray) {
      AbstractNode resultNode = (AbstractNode) obj;
      System.out.print(resultNode.getValue() + " ");
    }
    System.out.println("\ntoString : " + heap.toString());
    ArrayList<Integer> postOrderList = new ArrayList<>();
    Iterator<AbstractNode> postOrderIterator = heap.iterator();
    while (postOrderIterator.hasNext()) {
      postOrderList.add(postOrderIterator.next().getValue());
    }
    System.out.println("Post Order using internal iterator");
    postOrderList.forEach(nodeValue -> System.out.print(" " + nodeValue));

    System.out.println("\n \n Pre Order of all odd nodes of the heap");
    OddHeapDecorator oddHeapDecorator = new OddHeapDecorator(heap.getHead());
    Object[] res = oddHeapDecorator.toArray();
    System.out.print("toArray : ");
    for (Object obj : res) {
      AbstractNode node = (AbstractNode) obj;
      System.out.print(node.getValue() + " ");
    }
    System.out.println("\ntoString : " + oddHeapDecorator.toString());

    System.out.print("\n In Order of all nodes of the heap\n");
    HeapIterator inIterator = inOrder.getIterator();
    inIterator.treeTraversal(heap.getHead());
    while (inIterator.hasNext()) {
      AbstractNode inOutput = inIterator.next();
      System.out.print(" " + inOutput.getValue());
    }
  }
}