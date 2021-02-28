package com.sdsu;


public interface HeapIterator {

  void treeTraversal(AbstractNode node);

  boolean hasNext();

  AbstractNode next();
}