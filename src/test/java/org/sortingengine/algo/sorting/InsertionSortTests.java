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

class InsertionSortTests {
  @Test
  void test_insertionSort_withEmptyList() {
    List<Integer> emptyList = Collections.emptyList();
    List<Integer> sortedList = InsertionSort.insertionSort( emptyList, Integer::compare );
    assertTrue( sortedList.isEmpty(), "The sorted list should be empty." );
  }

  @Test
  void test_insertionSort_withSingleElement() {
    List<Integer> singleElementList = Collections.singletonList( 1 );
    List<Integer> sortedList = InsertionSort.insertionSort( singleElementList, Integer::compare );
    assertEquals( singleElementList, sortedList,
        "The sorted list should be equal to the original single-element list." );
  }

  @Test
  void test_insertionSort_withSortedInput() {
    List<Integer> alreadySortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = InsertionSort.insertionSort( alreadySortedList, Integer::compare );
    assertEquals( alreadySortedList, sortedList, "The sorted list should be equal to the already sorted input list." );
  }

  @Test
  void test_insertionSort_withReverseSortedInput() {
    List<Integer> reverseSortedList = Arrays.asList( 5, 4, 3, 2, 1 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = InsertionSort.insertionSort( reverseSortedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList,
        "The sorted list should match the expected sorted list after sorting a reverse sorted list." );
  }

  @Test
  void test_insertionSort_withDuplicateElements() {
    List<Integer> listWithDuplicates = Arrays.asList( 2, 3, 1, 2, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 2, 3, 3 );
    List<Integer> sortedList = InsertionSort.insertionSort( listWithDuplicates, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should handle duplicates correctly." );
  }

  @Test
  void test_insertionSort_withAllEqualElements() {
    List<Integer> equalElementsList = Arrays.asList( 1, 1, 1, 1, 1 );
    List<Integer> sortedList = InsertionSort.insertionSort( equalElementsList, Integer::compare );
    assertEquals( equalElementsList, sortedList,
        "The sorted list should be equal to the original list with all equal elements." );
  }

  @Test
  void test_insertionSort_withNegativeNumbers() {
    List<Integer> listWithNegatives = Arrays.asList( -3, 1, -2, 4, 0 );
    List<Integer> expectedSortedList = Arrays.asList( -3, -2, 0, 1, 4 );
    List<Integer> sortedList = InsertionSort.insertionSort( listWithNegatives, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should handle negative numbers correctly." );
  }

  @Test
  void test_insertionSort_withMixedNumbers() {
    List<Integer> mixedList = Arrays.asList( -3, 1, 5, -2, 4, 0 );
    List<Integer> expectedSortedList = Arrays.asList( -3, -2, 0, 1, 4, 5 );
    List<Integer> sortedList = InsertionSort.insertionSort( mixedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList,
        "The sorted list should correctly sort a mix of positive and negative numbers." );
  }

  @Test
  void test_insertionSort_withStrings() {
    List<String> stringList = Arrays.asList( "banana", "apple", "cherry" );
    List<String> expectedSortedList = Arrays.asList( "apple", "banana", "cherry" );
    List<String> sortedList = InsertionSort.insertionSort( stringList, Comparator.naturalOrder() );
    assertEquals( expectedSortedList, sortedList, "The sorted list should be sorted alphabetically." );
  }

  @Test
  void test_insertionSort_withCustomComparatorDescendingOrder() {
    List<Integer> unsortedList = Arrays.asList( 4, 2, 5, 1, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 5, 4, 3, 2, 1 );
    List<Integer> sortedList = InsertionSort.insertionSort( unsortedList, Comparator.reverseOrder() );
    assertEquals( expectedSortedList, sortedList, "The sorted list should be in descending order." );
  }

  @Test
  void test_insertionSort_withCustomObject() {
    List<User> users = Arrays.asList( new User( 3, "Charlie" ), new User( 1, "Alice" ), new User( 2, "Bob" ) );
    List<User> expectedSortedList = Arrays.asList( new User( 1, "Alice" ), new User( 2, "Bob" ),
        new User( 3, "Charlie" ) );
    List<User> sortedList = InsertionSort.insertionSort( users, Comparator.comparing( User::id ) );
    assertEquals( expectedSortedList, sortedList, "Users should be sorted by their ID." );
  }

  @Test
  void test_insertionSort_withNullList() {
    Exception exception = assertThrows( IllegalArgumentException.class,
        () -> InsertionSort.insertionSort( null, Integer::compare ) );
    assertEquals( "The list cannot be null.", exception.getMessage() );
  }

  @Test
  void test_insertionSort_withNullComparator() {
    List<Integer> list = Arrays.asList( 3, 1, 2 );
    Exception exception = assertThrows( IllegalArgumentException.class,
        () -> InsertionSort.insertionSort( list, null ) );
    assertEquals( "Comparator cannot be null.", exception.getMessage() );
  }

  @Test
  void test_insertionSort_withLargeDataset() {
    List<Integer> largeList = new ArrayList<>();
    for( int i = 1000; i > 0; i-- ) {
      largeList.add( i );
    }
    List<Integer> sortedList = InsertionSort.insertionSort( largeList, Integer::compare );

    for( int i = 1; i <= 1000; i++ ) {
      assertEquals( i, sortedList.get( i - 1 ), "Element " + i + " should be at position " + ( i - 1 ) );
    }
  }

  @Test
  void test_insertionSort_withNearlySortedInput() {
    List<Integer> nearlySortedList = Arrays.asList( 1, 3, 2, 4, 5, 7, 6, 8, 9, 10 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );
    List<Integer> sortedList = InsertionSort.insertionSort( nearlySortedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList,
        "The sorted list should match the expected sorted list for a nearly sorted input." );
  }
}