package com.sdsu;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is a heap implementation using reference(pointers). This class provides add node,
 * toArray, toString, post order traversal implementation.
 */

public class Heap extends AbstractCollection<AbstractNode> implements HeapIterator {

  private AbstractNode head;
  public Context heapType;

  public Heap() {
    this.head = new NullNode();
  }

  public Heap(AbstractNode head) {
    this.head = head;
  }

  public AbstractNode getHead() {
    return this.head;
  }

  public void setOrdering(String orderingStrategy) {
    if (orderingStrategy.equals("minheap")) {
      this.heapType = new Context(new MinHeap());
    } else {
      this.heapType = new Context(new MaxHeap());
    }
  }

  /**
   * This method adds a node by checking the height of the sub-heaps and adds the new node to the
   * sub-heap with lesser height
   *
   * @param newValue new node value to be added to the heap
   * @return true on successfully adding the new value
   */
  @Override
  public boolean add(AbstractNode newValue) {
    int insertResult = 0;
    if (this.head.isNull()) {
      this.head = new HeapNode();
      this.head.setValue(newValue.getValue());
    } else {
      AbstractNode parentFreePosition;
      AbstractNode freePosition = new HeapNode();

      int leftHeight = this.head.getHeapHeight(this.head.getLeftChild());
      int rightHeight = this.head.getHeapHeight(this.head.getRightChild());
      if (leftHeight <= rightHeight) {
        parentFreePosition = this.head.getLeftChild();
      } else {
        parentFreePosition = this.head.getRightChild();
      }
      if (parentFreePosition.isNull()) {
        parentFreePosition = this.head;
      }

      while (!parentFreePosition.getLeftChild().isNull() && !parentFreePosition.getRightChild()
          .isNull()) {
        AbstractNode interimParent = parentFreePosition.getLeftChild();
        if (!interimParent.getLeftChild().isNull() && !interimParent.getRightChild().isNull()) {
          parentFreePosition = parentFreePosition.getRightChild();
        } else {
          parentFreePosition = parentFreePosition.getLeftChild();
        }
      }

      if (parentFreePosition.getLeftChild().isNull()) {
        parentFreePosition.setLeftChild(freePosition);
      } else {
        parentFreePosition.setRightChild(freePosition);
      }

      freePosition.setParent(parentFreePosition);
      freePosition.setValue(newValue.getValue());
      freePosition.setLeftChild(new NullNode());
      freePosition.setRightChild(new NullNode());
      insertResult = 1;

      this.heapType.executeStrategy(parentFreePosition, freePosition);
    }
    return insertResult == 1;
  }

  public void swapNode(AbstractNode firstNode, AbstractNode secondNode) {
    int swap;
    swap = firstNode.getValue();
    firstNode.setValue(secondNode.getValue());
    secondNode.setValue(swap);
  }

  @Override
  public Iterator<AbstractNode> iterator() {
    return postOrderTraversal.iterator();
  }

  ArrayList<AbstractNode> postOrderTraversal = new ArrayList<>();

  @Override
  public void treeTraversal(AbstractNode node) {
    if (!node.isNull()) {
      treeTraversal(node.getLeftChild());
      treeTraversal(node.getRightChild());
      postOrderTraversal.add(node);
    }
  }

  @Override
  public Object[] toArray() {
    Object[] postOrderArray = new Object[size()];
    int index = 0;
    Iterator<AbstractNode> iterator = iterator();
    while (iterator.hasNext()) {
      AbstractNode node = iterator.next();
      postOrderArray[index] = node;
      index++;
    }
    return postOrderArray;
  }

  public String toString() {
    StringBuilder result = new StringBuilder();
    Iterator<AbstractNode> iterator = iterator();
    while (iterator.hasNext()) {
      AbstractNode oddNode = iterator.next();
      result.append(oddNode.getValue()).append(" ");
    }
    return result.toString();
  }

  @Override
  public int size() {
    return postOrderTraversal.size();
  }

  @Override
  public boolean hasNext() {
    return !postOrderTraversal.isEmpty();
  }

  @Override
  public AbstractNode next() {
    return postOrderTraversal.remove(0);
  }
}