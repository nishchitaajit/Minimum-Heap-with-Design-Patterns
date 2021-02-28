package com.sdsu;

/**
 * This class traverses the heap in pre-order fashion and
 * returns as output only the odd node values to the decorator class.
 */

import java.util.ArrayList;
import java.util.Stack;

public class OddFilter implements IteratorContainer {

  @Override
  public HeapIterator getIterator() {
    return new preOrderIterator();
  }

  private static class preOrderIterator implements HeapIterator {

    Stack<AbstractNode> preOrderStack;
    ArrayList<AbstractNode> preOrderList = new ArrayList<>();

    @Override
    public void treeTraversal(AbstractNode node) {
      preOrderStack = new Stack<>();
      preOrderStack.push(node);
      while (!preOrderStack.isEmpty()) {
        AbstractNode preOrderNode = preOrderStack.pop();
        preOrderList.add(preOrderNode);
        if (preOrderNode.getRightChild() != null) {
          preOrderStack.push(preOrderNode.getRightChild());
        }
        if (preOrderNode.getLeftChild() != null) {
          preOrderStack.push(preOrderNode.getLeftChild());
        }
      }
    }

    @Override
    public boolean hasNext() {
      for (AbstractNode integer : preOrderList) {
        if (integer.getValue() % 2 != 0) {
          return true;
        }
      }
      return false;
    }

    @Override
    public AbstractNode next() {
      for (int i = 0; i < preOrderList.size(); i++) {
        if (preOrderList.get(i).getValue() % 2 != 0) {
          return preOrderList.remove(i);
        }
      }
      return new NullNode();
    }
  }
}