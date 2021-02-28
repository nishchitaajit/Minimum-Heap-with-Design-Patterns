package com.sdsu;

/**
 * Concrete classes implementing the strategy interface
 */

public class MaxHeap implements HeapStrategy {

  @Override
  public boolean sortHeap(AbstractNode parentFreePosition, AbstractNode freePosition) {
    Heap heap = new Heap();
    boolean result = false;
    while (!parentFreePosition.isNull() && parentFreePosition.getValue() < freePosition
        .getValue()) {

      heap.swapNode(parentFreePosition, freePosition);
      freePosition = parentFreePosition;
      parentFreePosition = freePosition.getParent();
      result = true;
    }
    return result;
  }
}