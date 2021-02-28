package com.sdsu;

public interface TreeNode {

  int getValue();

  AbstractNode getLeftChild();

  AbstractNode getRightChild();

  AbstractNode getParent();

  void setParent(AbstractNode parent);

  void setLeftChild(AbstractNode leftChild);

  void setRightChild(AbstractNode rightChild);

  void setValue(int value);
}