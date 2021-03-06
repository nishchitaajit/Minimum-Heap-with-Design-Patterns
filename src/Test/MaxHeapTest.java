package Test;

import static org.junit.jupiter.api.Assertions.*;

import com.sdsu.AbstractNode;
import com.sdsu.HeapNode;
import com.sdsu.MaxHeap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxHeapTest {

  MaxHeap maxHeap = new MaxHeap();

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void sortHeapSwap() {
    AbstractNode firstNode = new HeapNode();
    firstNode.setValue(35);
    AbstractNode secondNode = new HeapNode();
    secondNode.setValue(55);
    assertTrue(maxHeap.sortHeap(firstNode, secondNode));
  }

  @Test
  void sortHeapNoSwap() {
    AbstractNode firstNode = new HeapNode();
    firstNode.setValue(55);
    AbstractNode secondNode = new HeapNode();
    secondNode.setValue(35);
    assertFalse(maxHeap.sortHeap(firstNode, secondNode));
  }
}