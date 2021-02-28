package Test;

import static org.junit.jupiter.api.Assertions.*;

import com.sdsu.AbstractNode;
import com.sdsu.Heap;
import com.sdsu.HeapNode;
import com.sdsu.OddFilter;
import com.sdsu.OddHeapDecorator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OddHeapDecoratorTest {

  OddFilter oddFilter = new OddFilter();
  Heap heap = new Heap();

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void decoratorToArrayMinHeap() {
    heap.setOrdering("minheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }
    ArrayList<Integer> actualList = new ArrayList<>();
    OddHeapDecorator oddHeapDecorator = new OddHeapDecorator(heap.getHead());
    Object[] res = oddHeapDecorator.toArray();
    for (Object obj : res) {
      AbstractNode decoratorNode = (AbstractNode) obj;
      actualList.add(decoratorNode.getValue());
    }

    List<Integer> expectedList = new ArrayList<>(
        Arrays.asList(45, 65, 81, 95, 99));
    Assertions.assertEquals(expectedList, actualList);
  }

  @Test
  void decoratorToArrayMaxHeap() {
    heap.setOrdering("maxheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }
    ArrayList<Integer> actualList = new ArrayList<>();
    OddHeapDecorator oddHeapDecorator = new OddHeapDecorator(heap.getHead());
    Object[] res = oddHeapDecorator.toArray();
    for (Object obj : res) {
      AbstractNode decoratorNode = (AbstractNode) obj;
      actualList.add(decoratorNode.getValue());
    }

    List<Integer> expectedList = new ArrayList<>(
        Arrays.asList(99, 45, 95, 65, 81));
    Assertions.assertEquals(expectedList, actualList);
  }

  @Test
  void size() {
    heap.setOrdering("minheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }
    OddHeapDecorator oddHeapDecorator = new OddHeapDecorator(heap.getHead());
    int actualSize = oddHeapDecorator.size();
    assertEquals(5, actualSize);
  }


  @Test
  void decoratorToStringMinHeap() {
    heap.setOrdering("minheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }

    OddHeapDecorator oddHeapDecorator = new OddHeapDecorator(heap.getHead());
    String actualString = oddHeapDecorator.toString();
    String expectedString = "45 65 81 95 99 ";
    assertEquals(expectedString, actualString);
  }

  @Test
  void decoratorToStringMaxHeap() {
    heap.setOrdering("maxheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }

    OddHeapDecorator oddHeapDecorator = new OddHeapDecorator(heap.getHead());
    String actualString = oddHeapDecorator.toString();
    String expectedString = "99 45 95 65 81 ";
    assertEquals(expectedString, actualString);
  }
}