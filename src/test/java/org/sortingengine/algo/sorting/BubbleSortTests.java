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

class BubbleSortTests {

  @Test
  void test_bubbleSort_withNullList() {
    Exception exception = assertThrows( IllegalArgumentException.class,
        () -> BubbleSort.bubbleSort( null, Integer::compare ) );
    assertEquals( "The list cannot be null.", exception.getMessage() );
  }

  @Test
  void test_bubbleSort_withNullComparator() {
    List<Integer> list = Arrays.asList( 3, 1, 2 );
    Exception exception = assertThrows( IllegalArgumentException.class, () -> BubbleSort.bubbleSort( list, null ) );
    assertEquals( "Comparator cannot be null.", exception.getMessage() );
  }

  @Test
  void test_bubbleSort_withDuplicateElements() {
    List<Integer> listWithDuplicates = Arrays.asList( 1, 3, 2, 1, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 1, 2, 3, 3 );
    List<Integer> sortedList = BubbleSort.bubbleSort( listWithDuplicates, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should handle duplicates correctly." );
  }

  @Test
  void test_bubbleSort_withNegativeNumbers() {
    List<Integer> listWithNegatives = Arrays.asList( -3, 1, -2, 4, 0 );
    List<Integer> expectedSortedList = Arrays.asList( -3, -2, 0, 1, 4 );
    List<Integer> sortedList = BubbleSort.bubbleSort( listWithNegatives, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should handle negative numbers correctly." );
  }

  @Test
  void test_bubbleSort_withUsersById() {
    List<User> users = Arrays.asList( new User( 3, "Alice" ), new User( 1, "Bob" ), new User( 2, "Charlie" ) );
    List<User> sortedUsers = BubbleSort.bubbleSort( users, Comparator.comparingInt( User::id ) );

    List<User> expected = Arrays.asList( new User( 1, "Bob" ), new User( 2, "Charlie" ), new User( 3, "Alice" ) );
    assertEquals( expected, sortedUsers, "Users should be sorted by their ID." );
  }

  @Test
  void test_bubbleSort_withUsersByName() {
    List<User> users = Arrays.asList( new User( 1, "Charlie" ), new User( 2, "Alice" ), new User( 3, "Bob" ) );
    List<User> sortedUsers = BubbleSort.bubbleSort( users, Comparator.comparing( User::name ) );

    List<User> expected = Arrays.asList( new User( 2, "Alice" ), new User( 3, "Bob" ), new User( 1, "Charlie" ) );
    assertEquals( expected, sortedUsers, "Users should be sorted by their name." );
  }

  @Test
  void test_bubbleSort_withEmptyList() {
    List<Integer> emptyList = Collections.emptyList();
    List<Integer> sortedList = BubbleSort.bubbleSort( emptyList, Integer::compare );
    assertTrue( sortedList.isEmpty(), "The sorted list should be empty." );
  }

  @Test
  void test_bubbleSort_withSingleElement() {
    List<Integer> singleElementList = Collections.singletonList( 1 );
    List<Integer> sortedList = BubbleSort.bubbleSort( singleElementList, Integer::compare );
    assertEquals( singleElementList, sortedList,
        "The sorted list should be equal to the original single-element list." );
  }

  @Test
  void test_bubbleSort_withSortedInput() {
    List<Integer> alreadySortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = BubbleSort.bubbleSort( alreadySortedList, Integer::compare );
    assertEquals( alreadySortedList, sortedList, "The sorted list should be equal to the already sorted input list." );
  }

  @Test
  void test_bubbleSort_withUnsortedInput() {
    List<Integer> unsortedList = Arrays.asList( 4, 2, 5, 1, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = BubbleSort.bubbleSort( unsortedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should match the expected sorted list." );
  }

  @Test
  void test_bubbleSort_withReverseSortedInput() {
    List<Integer> reverseSortedList = Arrays.asList( 5, 4, 3, 2, 1 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = BubbleSort.bubbleSort( reverseSortedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList,
        "The sorted list should match the expected sorted list after sorting a reverse sorted list." );
  }

  @Test
  void test_bubbleSort_withAllEqualElements() {
    List<Integer> equalElementsList = Arrays.asList( 1, 1, 1, 1, 1 );
    List<Integer> sortedList = BubbleSort.bubbleSort( equalElementsList, Integer::compare );
    assertEquals( equalElementsList, sortedList,
        "The sorted list should be equal to the original list with all equal elements." );
  }

  @Test
  void test_bubbleSort_withCustomComparator() {
    List<String> stringList = Arrays.asList( "banana", "apple", "cherry" );
    List<String> expectedSortedList = Arrays.asList( "apple", "banana", "cherry" );
    List<String> sortedList = BubbleSort.bubbleSort( stringList, Comparator.naturalOrder() );
    assertEquals( expectedSortedList, sortedList, "The sorted list should be sorted alphabetically." );
  }
}