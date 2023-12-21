package org.sortingengine.algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.sortingengine.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HeapSortTests {

  @Test
  void test_heapSort_withEmptyList() {
    List<Integer> emptyList = Collections.emptyList();
    List<Integer> sortedList = HeapSort.heapSort( emptyList, Integer::compare );
    assertTrue( sortedList.isEmpty(), "The sorted list should be empty." );
  }

  @Test
  void test_heapSort_withSingleElement() {
    List<Integer> singleElementList = Collections.singletonList( 1 );
    List<Integer> sortedList = HeapSort.heapSort( singleElementList, Integer::compare );
    assertEquals( singleElementList, sortedList,
        "The sorted list should be equal to the original single-element list." );
  }

  @Test
  void test_heapSort_withSortedInput() {
    List<Integer> alreadySortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = HeapSort.heapSort( alreadySortedList, Integer::compare );
    assertEquals( alreadySortedList, sortedList, "The sorted list should be equal to the already sorted input list." );
  }

  @Test
  void test_heapSort_withReverseSortedInput() {
    List<Integer> reverseSortedList = Arrays.asList( 5, 4, 3, 2, 1 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = HeapSort.heapSort( reverseSortedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList,
        "The sorted list should match the expected sorted list after sorting a reverse sorted list." );
  }

  @Test
  void test_heapSort_withDuplicateElements() {
    List<Integer> listWithDuplicates = Arrays.asList( 2, 3, 1, 2, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 2, 3, 3 );
    List<Integer> sortedList = HeapSort.heapSort( listWithDuplicates, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should handle duplicates correctly." );
  }

  @Test
  void test_heapSort_withAllEqualElements() {
    List<Integer> equalElementsList = Arrays.asList( 1, 1, 1, 1, 1 );
    List<Integer> sortedList = HeapSort.heapSort( equalElementsList, Integer::compare );
    assertEquals( equalElementsList, sortedList,
        "The sorted list should be equal to the original list with all equal elements." );
  }

  @Test
  void test_heapSort_withNegativeNumbers() {
    List<Integer> listWithNegatives = Arrays.asList( -3, 1, -2, 4, 0 );
    List<Integer> expectedSortedList = Arrays.asList( -3, -2, 0, 1, 4 );
    List<Integer> sortedList = HeapSort.heapSort( listWithNegatives, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should handle negative numbers correctly." );
  }

  @Test
  void test_heapSort_withLargeDataset() {
    List<Integer> largeList = new ArrayList<>();
    for( int i = 0; i < 1000; i++ ) {
      largeList.add( (int) ( Math.random() * 1000 ) );
    }
    List<Integer> sortedList = HeapSort.heapSort( largeList, Integer::compare );
    assertTrue( isSorted( sortedList, Integer::compare ), "The large list should be sorted correctly." );
  }

  @Test
  void test_heapSort_withCustomObject() {
    List<User> users = Arrays.asList( new User( 3, "Charlie" ), new User( 1, "Alice" ), new User( 2, "Bob" ) );
    List<User> expectedSortedList = Arrays.asList( new User( 1, "Alice" ), new User( 2, "Bob" ),
        new User( 3, "Charlie" ) );
    List<User> sortedList = HeapSort.heapSort( users, Comparator.comparing( User::id ) );
    assertEquals( expectedSortedList, sortedList, "Users should be sorted by their ID." );
  }

  @Test
  void test_heapSort_withNullList() {
    assertThrows( IllegalArgumentException.class, () -> HeapSort.heapSort( null, Integer::compare ) );
  }

  @Test
  void test_heapSort_withNullComparator() {
    List<Integer> list = Arrays.asList( 3, 1, 2 );
    assertThrows( IllegalArgumentException.class, () -> HeapSort.heapSort( list, null ) );
  }

  @Test
  void test_heapSort_withCustomComparatorDescendingOrder() {
    List<Integer> unsortedList = Arrays.asList( 4, 2, 5, 1, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 5, 4, 3, 2, 1 );
    List<Integer> sortedList = HeapSort.heapSort( unsortedList, Comparator.reverseOrder() );
    assertEquals( expectedSortedList, sortedList, "The sorted list should be in descending order." );
  }

  private <T> boolean isSorted( List<T> list, Comparator<T> comparator ) {
    for( int i = 0; i < list.size() - 1; i++ ) {
      if( comparator.compare( list.get( i ), list.get( i + 1 ) ) > 0 ) {
        return false;
      }
    }
    return true;
  }
}
