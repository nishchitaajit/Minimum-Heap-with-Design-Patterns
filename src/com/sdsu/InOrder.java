package com.sdsu;

/*
 * This class implements the in-order traversal of the heap through an external iterator.
 */

import java.util.Stack;

public class InOrder implements IteratorContainer {

  @Override
  public HeapIterator getIterator() {
    return new InOrderIterator();
  }

  private static class InOrderIterator implements HeapIterator {

    Stack<AbstractNode> inOrderStack = new Stack<>();

    @Override
    public void treeTraversal(AbstractNode node) {
      AbstractNode head = node;
      while (!head.isNull()) {
        inOrderStack.push(head);
        head = head.getLeftChild();
      }
    }

    @Override
    public boolean hasNext() {
      return !inOrderStack.isEmpty();
    }

    @Override
    public AbstractNode next() {
      while (!inOrderStack.isEmpty()) {
        AbstractNode inOrderNode = inOrderStack.pop();
        AbstractNode result = inOrderNode;

        inOrderNode = inOrderNode.getRightChild();
        while (!inOrderNode.isNull()) {
          inOrderStack.push(inOrderNode);
          inOrderNode = inOrderNode.getLeftChild();
        }
        return result;
      }
      return new NullNode();
    }
  }
}