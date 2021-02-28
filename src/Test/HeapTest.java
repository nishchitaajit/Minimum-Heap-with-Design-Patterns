package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import com.sdsu.AbstractNode;
import com.sdsu.Heap;
import com.sdsu.HeapNode;
import com.sdsu.NullNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeapTest {

  Heap heap = new Heap();

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void getHead() {
    Heap nullHeap = new Heap();
    assertNotNull(nullHeap.getHead());
  }

  @Test
  void addMinHeap() {
    heap.setOrdering("minheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{66, 87, 123};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }
    assertEquals(66, heap.getHead().getValue(), 0.0);
    assertEquals(87, heap.getHead().getLeftChild().getValue(), 0.0);
    assertEquals(123, heap.getHead().getRightChild().getValue(), 0.0);
  }

  @Test
  void addMaxHeap() {
    heap.setOrdering("maxheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{66, 87, 123};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }
    assertEquals(123, heap.getHead().getValue(), 0.0);
    assertEquals(66, heap.getHead().getLeftChild().getValue(), 0.0);
    assertEquals(87, heap.getHead().getRightChild().getValue(), 0.0);
  }

  @Test
  public void postOrderTraversalNull() {
    heap.setOrdering("minheap");
    AbstractNode node = new NullNode();
    heap.treeTraversal(node);
    Iterator<AbstractNode> iterator = heap.iterator();
    boolean result = iterator.hasNext();
    assertFalse(result);
  }

  @Test
  void postOrderTraversalMinHeap() {
    heap.setOrdering("minheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }

    ArrayList<Integer> actualList = new ArrayList<>();
    heap.treeTraversal(heap.getHead());
    Iterator<AbstractNode> iterator = heap.iterator();
    while (iterator.hasNext()) {
      AbstractNode nextNode = iterator.next();
      actualList.add(nextNode.getValue());
    }
    List<Integer> expectedList = new ArrayList<>(
        Arrays.asList(96, 90, 65, 82, 50, 95, 81, 99, 72, 45));
    Assertions.assertEquals(expectedList, actualList);
  }

  @Test
  void postOrderTraversalMaxHeap() {
    heap.setOrdering("maxheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }

    ArrayList<Integer> actualList = new ArrayList<>();
    heap.treeTraversal(heap.getHead());
    Iterator<AbstractNode> iterator = heap.iterator();
    while (iterator.hasNext()) {
      AbstractNode nextNode = iterator.next();
      actualList.add(nextNode.getValue());
    }
    List<Integer> expectedList = new ArrayList<>(
        Arrays.asList(45, 50, 82, 72, 90, 65, 95, 81, 96, 99));
    Assertions.assertEquals(expectedList, actualList);
  }

  @Test
  void postOrderToArrayMinHeap() {
    heap.setOrdering("minheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }

    heap.treeTraversal(heap.getHead());
    int index = 0;
    Object[] heapArray = heap.toArray();
    int[] actualArray = new int[10];
    for (Object obj : heapArray) {
      AbstractNode resultNode = (AbstractNode) obj;
      actualArray[index] = resultNode.getValue();
      index++;
    }

    int[] expectedArray = new int[]{96, 90, 65, 82, 50, 95, 81, 99, 72, 45};
    assertArrayEquals(expectedArray, actualArray);
  }

  @Test
  void postOrderToArrayMaxHeap() {
    heap.setOrdering("maxheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }

    heap.treeTraversal(heap.getHead());
    int index = 0;
    Object[] heapArray = heap.toArray();
    int[] actualArray = new int[10];
    for (Object obj : heapArray) {
      AbstractNode resultNode = (AbstractNode) obj;
      actualArray[index] = resultNode.getValue();
      index++;
    }

    int[] expectedArray = new int[]{45, 50, 82, 72, 90, 65, 95, 81, 96, 99};
    assertArrayEquals(expectedArray, actualArray);
  }

  @Test
  void postOrderToStringMinHeap() {
    heap.setOrdering("minheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }

    heap.treeTraversal(heap.getHead());
    String actualString = heap.toString();
    String expectedString = "96 90 65 82 50 95 81 99 72 45 ";
    Assertions.assertEquals(expectedString, actualString);
  }

  @Test
  void postOrderToStringMaxHeap() {
    heap.setOrdering("maxheap");
    AbstractNode node = new HeapNode();
    int[] input = new int[]{45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
    for (int i : input) {
      node.setValue(i);
      heap.add(node);
    }

    heap.treeTraversal(heap.getHead());
    String actualString = heap.toString();
    String expectedString = "45 50 82 72 90 65 95 81 96 99 ";
    Assertions.assertEquals(expectedString, actualString);
  }
}