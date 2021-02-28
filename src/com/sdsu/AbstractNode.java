package com.sdsu;

/**
 * Defines methods of NullNode and HeapNode classes.
 */

public abstract class AbstractNode implements TreeNode {

  protected int value;
  protected AbstractNode parent;
  protected AbstractNode leftChild;
  protected AbstractNode rightChild;

  public abstract boolean isNull();

  public abstract int getHeapHeight(AbstractNode node);

  @Override
  public int getValue() {
    return this.value;
  }

  @Override
  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public AbstractNode getParent() {
    return this.parent;
  }

  @Override
  public void setParent(AbstractNode parent) {
    this.parent = parent;
  }

  @Override
  public AbstractNode getLeftChild() {
    return this.leftChild;
  }

  @Override
  public void setLeftChild(AbstractNode leftChild) {
    this.leftChild = leftChild;
  }

  @Override
  public AbstractNode getRightChild() {
    return this.rightChild;
  }

  @Override
  public void setRightChild(AbstractNode rightChild) {
    this.rightChild = rightChild;
  }
}