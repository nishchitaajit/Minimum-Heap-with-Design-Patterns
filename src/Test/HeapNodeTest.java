package Test;

import static org.junit.Assert.assertEquals;

import com.sdsu.AbstractNode;
import com.sdsu.Heap;
import com.sdsu.HeapNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeapNodeTest {

  Heap heap = new Heap();
  HeapNode heapNode = new HeapNode();

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void getHeapHeightMinHeap() {
    AbstractNode node = new HeapNode();
    heap.setOrdering("minheap");
    int[] input = new int[]{123, 87, 66, 67, 879, 65, 23};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }
    int treeHeight = heapNode.getHeapHeight(heap.getHead());
    assertEquals(4, treeHeight);
  }

  @Test
  void getHeapHeightMaxHeap() {
    AbstractNode node = new HeapNode();
    heap.setOrdering("maxheap");
    int[] input = new int[]{123, 87, 66, 67, 879, 65, 23};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }
    int treeHeight = heapNode.getHeapHeight(heap.getHead());
    assertEquals(4, treeHeight);
  }

  @Test
  void isNull() {
    int treeHeight = heapNode.getHeapHeight(heap.getHead());
    assertEquals(0, treeHeight);
  }
}