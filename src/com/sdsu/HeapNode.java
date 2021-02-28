package com.sdsu;


public class HeapNode extends AbstractNode {

  public HeapNode() {
    this.parent = new NullNode();
    this.leftChild = new NullNode();
    this.rightChild = new NullNode();
  }

  @Override
  public int getHeapHeight(AbstractNode node) {

    if (node.isNull()) {
      return 0;
    }
    int leftTreeHeight = getHeapHeight(node.getLeftChild());
    int rightTreeHeight = getHeapHeight(node.getRightChild());
    if (leftTreeHeight > rightTreeHeight) {
      return leftTreeHeight + 1;
    } else {
      return rightTreeHeight + 1;
    }
  }

  @Override
  public boolean isNull() {
    return false;
  }
}