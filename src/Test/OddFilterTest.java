package Test;

import static org.junit.jupiter.api.Assertions.*;

import com.sdsu.AbstractNode;
import com.sdsu.Heap;
import com.sdsu.HeapNode;
import com.sdsu.HeapIterator;
import com.sdsu.OddFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OddFilterTest {

  OddFilter oddFilter = new OddFilter();
  Heap heap = new Heap();

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  public void OddFilterNull() {
    HeapIterator oddIterator = oddFilter.getIterator();
    oddIterator.treeTraversal(heap.getHead());
    assertFalse(oddIterator.hasNext());
  }

  @Test
  void oddFilterMinHeap() {
    heap.setOrdering("minheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }

    ArrayList<Integer> actualList = new ArrayList<>();
    HeapIterator oddIterator = oddFilter.getIterator();
    oddIterator.treeTraversal(heap.getHead());
    while (oddIterator.hasNext()) {
      AbstractNode oddOutput = oddIterator.next();
      actualList.add(oddOutput.getValue());
    }

    List<Integer> expectedList = new ArrayList<>(
        Arrays.asList(45, 65, 81, 95, 99));
    Assertions.assertEquals(expectedList, actualList);
  }

  @Test
  void oddFilterMaxHeap() {
    heap.setOrdering("maxheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }

    ArrayList<Integer> actualList = new ArrayList<>();
    HeapIterator oddIterator = oddFilter.getIterator();
    oddIterator.treeTraversal(heap.getHead());
    while (oddIterator.hasNext()) {
      AbstractNode oddOutput = oddIterator.next();
      actualList.add(oddOutput.getValue());
    }

    List<Integer> expectedList = new ArrayList<>(
        Arrays.asList(99, 45, 95, 65, 81));
    Assertions.assertEquals(expectedList, actualList);
  }
}