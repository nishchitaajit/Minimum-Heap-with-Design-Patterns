
package Test;

import static org.junit.jupiter.api.Assertions.*;

import com.sdsu.AbstractNode;
import com.sdsu.Heap;
import com.sdsu.HeapNode;
import com.sdsu.InOrder;
import com.sdsu.HeapIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InOrderTest {

  Heap heap = new Heap();
  InOrder inOrder = new InOrder();

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  public void inOrderTraversalNull() {
    HeapIterator inIterator = inOrder.getIterator();
    inIterator.treeTraversal(heap.getHead());
    assertFalse(inIterator.hasNext());
  }


  @Test
  void inOrderTraversalMinHeap() {
    heap.setOrdering("minheap");
    AbstractNode j = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      j.setValue(i);
      heap.add(j);
    }

    ArrayList<Integer> actualList = new ArrayList<>();
    HeapIterator inIterator = inOrder.getIterator();
    inIterator.treeTraversal(heap.getHead());
    while (inIterator.hasNext()) {
      AbstractNode inOutput = inIterator.next();
      actualList.add(inOutput.getValue());
    }

    List<Integer> expectedList = new ArrayList<>(
        Arrays.asList(96, 65, 90, 50, 82, 45, 95, 81, 72, 99));
    Assertions.assertEquals(expectedList, actualList);
  }

  @Test
  void inOrderTraversalMaxHeap() {
    heap.setOrdering("maxheap");
    AbstractNode j = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      j.setValue(i);
      heap.add(j);
    }

    ArrayList<Integer> actualList = new ArrayList<>();
    HeapIterator inIterator = inOrder.getIterator();
    inIterator.treeTraversal(heap.getHead());
    while (inIterator.hasNext()) {
      AbstractNode inOutput = inIterator.next();
      actualList.add(inOutput.getValue());
    }

    List<Integer> expectedList = new ArrayList<>(
        Arrays.asList(45, 82, 50, 90, 72, 99, 65, 95, 96, 81));
    Assertions.assertEquals(expectedList, actualList);
  }
}