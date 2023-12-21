package org.sortingengine.algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.sortingengine.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuickSortTests {
  @Test
  void test_quickSort_withEmptyList() {
    List<Integer> emptyList = Collections.emptyList();
    List<Integer> sortedList = QuickSort.quickSort( emptyList, Integer::compare );
    assertTrue( sortedList.isEmpty(), "The sorted list should be empty." );
  }

  @Test
  void test_quickSort_withSingleElement() {
    List<Integer> singleElementList = Collections.singletonList( 1 );
    List<Integer> sortedList = QuickSort.quickSort( singleElementList, Integer::compare );
    assertEquals( singleElementList, sortedList,
        "The sorted list should be equal to the original single-element list." );
  }

  @Test
  void test_quickSort_withSortedInput() {
    List<Integer> alreadySortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = QuickSort.quickSort( alreadySortedList, Integer::compare );
    assertEquals( alreadySortedList, sortedList, "The sorted list should be equal to the already sorted input list." );
  }

  @Test
  void test_quickSort_withReverseSortedInput() {
    List<Integer> reverseSortedList = Arrays.asList( 5, 4, 3, 2, 1 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = QuickSort.quickSort( reverseSortedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList,
        "The sorted list should match the expected sorted list after sorting a reverse sorted list." );
  }

  @Test
  void test_quickSort_withDuplicateElements() {
    List<Integer> listWithDuplicates = Arrays.asList( 2, 3, 1, 2, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 2, 3, 3 );
    List<Integer> sortedList = QuickSort.quickSort( listWithDuplicates, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should handle duplicates correctly." );
  }

  @Test
  void test_quickSort_withAllEqualElements() {
    List<Integer> equalElementsList = Arrays.asList( 1, 1, 1, 1, 1 );
    List<Integer> sortedList = QuickSort.quickSort( equalElementsList, Integer::compare );
    assertEquals( equalElementsList, sortedList,
        "The sorted list should be equal to the original list with all equal elements." );
  }

  @Test
  void test_quickSort_withNegativeNumbers() {
    List<Integer> listWithNegatives = Arrays.asList( -3, 1, -2, 4, 0 );
    List<Integer> expectedSortedList = Arrays.asList( -3, -2, 0, 1, 4 );
    List<Integer> sortedList = QuickSort.quickSort( listWithNegatives, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should handle negative numbers correctly." );
  }

  @Test
  void test_quickSort_withLargeDataset() {
    List<Integer> largeList = new ArrayList<>();
    Random rand = new Random();
    for( int i = 0; i < 1000; i++ ) {
      largeList.add( rand.nextInt( 1000 ) );
    }
    List<Integer> sortedList = QuickSort.quickSort( largeList, Integer::compare );
    assertTrue( isSorted( sortedList, Integer::compare ), "The large list should be sorted correctly." );
  }

  @Test
  void test_quickSort_withCustomObject() {
    List<User> users = Arrays.asList( new User( 3, "Charlie" ), new User( 1, "Alice" ), new User( 2, "Bob" ) );
    List<User> expectedSortedList = Arrays.asList( new User( 1, "Alice" ), new User( 2, "Bob" ),
        new User( 3, "Charlie" ) );
    List<User> sortedList = QuickSort.quickSort( users, Comparator.comparing( User::id ) );
    assertEquals( expectedSortedList, sortedList, "Users should be sorted by their ID." );
  }

  @Test
  void test_quickSort_withNullList() {
    Exception exception = assertThrows( IllegalArgumentException.class,
        () -> QuickSort.quickSort( null, Integer::compare ) );
    assertEquals( "The list cannot be null.", exception.getMessage() );
  }

  @Test
  void test_quickSort_withNullComparator() {
    List<Integer> list = Arrays.asList( 3, 1, 2 );
    Exception exception = assertThrows( IllegalArgumentException.class, () -> QuickSort.quickSort( list, null ) );
    assertEquals( "Comparator cannot be null.", exception.getMessage() );
  }

  @Test
  void test_quickSort_withNearlySortedInput() {
    List<Integer> nearlySortedList = new ArrayList<>( Arrays.asList( 1, 3, 2, 4, 5, 6, 7, 8, 9, 10 ) );
    Collections.swap( nearlySortedList, 1, 2 ); // Introduce a minor unsorted condition
    List<Integer> sortedList = QuickSort.quickSort( nearlySortedList, Integer::compare );
    assertTrue( isSorted( sortedList, Integer::compare ), "The nearly sorted list should be sorted correctly." );
  }

  @Test
  void test_quickSort_withStrings() {
    List<String> stringList = Arrays.asList( "banana", "apple", "cherry" );
    List<String> expectedSortedList = Arrays.asList( "apple", "banana", "cherry" );
    List<String> sortedList = QuickSort.quickSort( stringList, Comparator.naturalOrder() );
    assertEquals( expectedSortedList, sortedList, "The sorted list should be sorted alphabetically." );
  }

  @Test
  void test_quickSort_withCustomComparatorDescendingOrder() {
    List<Integer> unsortedList = Arrays.asList( 4, 2, 5, 1, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 5, 4, 3, 2, 1 );
    List<Integer> sortedList = QuickSort.quickSort( unsortedList, Comparator.reverseOrder() );
    assertEquals( expectedSortedList, sortedList, "The sorted list should be in descending order." );
  }

  // Utility method to check if a list is sorted
  private <T> boolean isSorted( List<T> list, Comparator<T> comparator ) {
    for( int i = 0; i < list.size() - 1; i++ ) {
      if( comparator.compare( list.get( i ), list.get( i + 1 ) ) > 0 ) {
        return false;
      }
    }
    return true;
  }
}