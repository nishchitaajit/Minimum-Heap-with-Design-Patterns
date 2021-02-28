package com.sdsu;

/**
 * The base interface for creating strategy classes to implement min or max strategies.
 */

public interface HeapStrategy {

  boolean sortHeap(AbstractNode parentFreePosition, AbstractNode freePosition);
}