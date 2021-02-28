package com.sdsu;

/**
 * This class invokes the OddFilter iterator and gives as output an
 * array and a string of odd node values in the pre-order traversal way.
 */

public class OddHeapDecorator extends Heap {

  HeapIterator heapIterator;

  public OddHeapDecorator(AbstractNode head) {
    super(head);
    OddFilter oddFilter = new OddFilter();
    this.heapIterator = oddFilter.getIterator();
  }

  public HeapIterator getHeapIterator() {
    heapIterator.treeTraversal(this.getHead());
    return heapIterator;
  }

  @Override
  public int size() {
    int counter = 0;
    HeapIterator iterator = getHeapIterator();
    while (iterator.hasNext()) {
      iterator.next();
      counter++;
    }
    return counter;
  }

  @Override
  public Object[] toArray() {
    Object[] oddArray = new Object[size()];
    int index = 0;
    HeapIterator iterator = getHeapIterator();
    while (iterator.hasNext()) {
      AbstractNode node = iterator.next();
      oddArray[index] = node;
      index++;
    }
    return oddArray;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    HeapIterator iterator = getHeapIterator();
    while (iterator.hasNext()) {
      AbstractNode oddNode = iterator.next();
      result.append(oddNode.getValue()).append(" ");
    }
    return result.toString();
  }
}