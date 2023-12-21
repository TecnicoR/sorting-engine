package org.sortingengine.algo.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.sortingengine.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SelectionSortTests {
  @Test
  void test_selectionSort_withEmptyList() {
    List<Integer> emptyList = Collections.emptyList();
    List<Integer> sortedList = SelectionSort.selectionSort( emptyList, Integer::compare );
    assertTrue( sortedList.isEmpty(), "The sorted list should be empty." );
  }

  @Test
  void test_selectionSort_withSingleElement() {
    List<Integer> singleElementList = Collections.singletonList( 1 );
    List<Integer> sortedList = SelectionSort.selectionSort( singleElementList, Integer::compare );
    assertEquals( singleElementList, sortedList,
        "The sorted list should be equal to the original single-element list." );
  }

  @Test
  void test_selectionSort_withSortedInput() {
    List<Integer> alreadySortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = SelectionSort.selectionSort( alreadySortedList, Integer::compare );
    assertEquals( alreadySortedList, sortedList, "The sorted list should be equal to the already sorted input list." );
  }

  @Test
  void test_selectionSort_withUnsortedInput() {
    List<Integer> unsortedList = Arrays.asList( 4, 2, 5, 1, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = SelectionSort.selectionSort( unsortedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should match the expected sorted list." );
  }

  @Test
  void test_selectionSort_withReverseSortedInput() {
    List<Integer> reverseSortedList = Arrays.asList( 5, 4, 3, 2, 1 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = SelectionSort.selectionSort( reverseSortedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList,
        "The sorted list should match the expected sorted list after sorting a reverse sorted list." );
  }

  @Test
  void test_selectionSort_withAllEqualElements() {
    List<Integer> equalElementsList = Arrays.asList( 1, 1, 1, 1, 1 );
    List<Integer> sortedList = SelectionSort.selectionSort( equalElementsList, Integer::compare );
    assertEquals( equalElementsList, sortedList,
        "The sorted list should be equal to the original list with all equal elements." );
  }

  @Test
  void test_selectionSort_withCustomObject() {
    List<User> users = Arrays.asList( new User( 3, "Charlie" ), new User( 1, "Alice" ), new User( 2, "Bob" ) );
    List<User> expectedSortedList = Arrays.asList( new User( 1, "Alice" ), new User( 2, "Bob" ),
        new User( 3, "Charlie" ) );
    List<User> sortedList = SelectionSort.selectionSort( users, Comparator.comparing( User::id ) );
    assertEquals( expectedSortedList, sortedList, "Users should be sorted by their ID." );
  }

  @Test
  void test_selectionSort_withNullList() {
    Exception exception = assertThrows( IllegalArgumentException.class,
        () -> SelectionSort.selectionSort( null, Integer::compare ) );
    assertEquals( "The list cannot be null.", exception.getMessage() );
  }

  @Test
  void test_selectionSort_withNullComparator() {
    List<Integer> list = Arrays.asList( 3, 1, 2 );
    Exception exception = assertThrows( IllegalArgumentException.class,
        () -> SelectionSort.selectionSort( list, null ) );
    assertEquals( "Comparator cannot be null.", exception.getMessage() );
  }

  @Test
  void test_selectionSort_withNegativeNumbers() {
    List<Integer> listWithNegatives = Arrays.asList( -3, 1, -2, 4, 0 );
    List<Integer> expectedSortedList = Arrays.asList( -3, -2, 0, 1, 4 );
    List<Integer> sortedList = SelectionSort.selectionSort( listWithNegatives, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should handle negative numbers correctly." );
  }

  @Test
  void test_selectionSort_withDuplicateElements() {
    List<Integer> listWithDuplicates = Arrays.asList( 2, 3, 1, 2, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 2, 3, 3 );
    List<Integer> sortedList = SelectionSort.selectionSort( listWithDuplicates, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should handle duplicates correctly." );
  }

  @Test
  void test_selectionSort_withCustomComparatorDescendingOrder() {
    List<Integer> unsortedList = Arrays.asList( 4, 2, 5, 1, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 5, 4, 3, 2, 1 );
    List<Integer> sortedList = SelectionSort.selectionSort( unsortedList, Comparator.reverseOrder() );
    assertEquals( expectedSortedList, sortedList, "The sorted list should be in descending order." );
  }

  @Test
  void test_selectionSort_withStrings() {
    List<String> stringList = Arrays.asList( "banana", "apple", "cherry" );
    List<String> expectedSortedList = Arrays.asList( "apple", "banana", "cherry" );
    List<String> sortedList = SelectionSort.selectionSort( stringList, Comparator.naturalOrder() );
    assertEquals( expectedSortedList, sortedList, "The sorted list should be sorted alphabetically." );
  }

  @Test
  void test_selectionSort_withUserByName() {
    List<User> users = Arrays.asList( new User( 3, "Charlie" ), new User( 1, "Alice" ), new User( 2, "Bob" ) );
    List<User> expectedSortedList = Arrays.asList( new User( 1, "Alice" ), new User( 2, "Bob" ),
        new User( 3, "Charlie" ) );
    List<User> sortedList = SelectionSort.selectionSort( users, Comparator.comparing( User::name ) );
    assertEquals( expectedSortedList, sortedList, "Users should be sorted by their name." );
  }
}