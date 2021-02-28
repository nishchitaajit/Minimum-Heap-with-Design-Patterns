package com.sdsu;

public class Context {

  private final HeapStrategy strategy;

  public Context(HeapStrategy strategy) {
    this.strategy = strategy;
  }

  public boolean executeStrategy(AbstractNode parentFreePosition, AbstractNode freePosition) {
    return strategy.sortHeap(parentFreePosition, freePosition);
  }
}