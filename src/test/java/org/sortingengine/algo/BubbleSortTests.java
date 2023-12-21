package org.sortingengine.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.sortingengine.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BubbleSortTests {

  @Test
  void test_bubbleSort_withUsersById() {
    List<User> users = Arrays.asList( new User( 3, "Alice" ), new User( 1, "Bob" ), new User( 2, "Charlie" ) );
    List<User> sortedUsers = SortingEngine.bubbleSort( users, Comparator.comparingInt( User::getId ) );

    List<User> expected = Arrays.asList( new User( 1, "Bob" ), new User( 2, "Charlie" ), new User( 3, "Alice" ) );
    assertEquals( expected, sortedUsers, "Users should be sorted by their ID." );
  }

  @Test
  void test_bubbleSort_withUsersByName() {
    List<User> users = Arrays.asList( new User( 1, "Charlie" ), new User( 2, "Alice" ), new User( 3, "Bob" ) );
    List<User> sortedUsers = SortingEngine.bubbleSort( users, Comparator.comparing( User::getName ) );

    List<User> expected = Arrays.asList( new User( 2, "Alice" ), new User( 3, "Bob" ), new User( 1, "Charlie" ) );
    assertEquals( expected, sortedUsers, "Users should be sorted by their name." );
  }

  @Test
  void test_bubbleSort_withEmptyList() {
    List<Integer> emptyList = Collections.emptyList();
    List<Integer> sortedList = SortingEngine.bubbleSort( emptyList, Integer::compare );
    assertTrue( sortedList.isEmpty(), "The sorted list should be empty." );
  }

  @Test
  void test_bubbleSort_withSingleElement() {
    List<Integer> singleElementList = Collections.singletonList( 1 );
    List<Integer> sortedList = SortingEngine.bubbleSort( singleElementList, Integer::compare );
    assertEquals( singleElementList, sortedList,
        "The sorted list should be equal to the original single-element list." );
  }

  @Test
  void test_bubbleSort_withSortedInput() {
    List<Integer> alreadySortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = SortingEngine.bubbleSort( alreadySortedList, Integer::compare );
    assertEquals( alreadySortedList, sortedList, "The sorted list should be equal to the already sorted input list." );
  }

  @Test
  void test_bubbleSort_withUnsortedInput() {
    List<Integer> unsortedList = Arrays.asList( 4, 2, 5, 1, 3 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = SortingEngine.bubbleSort( unsortedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList, "The sorted list should match the expected sorted list." );
  }

  @Test
  void test_bubbleSort_withReverseSortedInput() {
    List<Integer> reverseSortedList = Arrays.asList( 5, 4, 3, 2, 1 );
    List<Integer> expectedSortedList = Arrays.asList( 1, 2, 3, 4, 5 );
    List<Integer> sortedList = SortingEngine.bubbleSort( reverseSortedList, Integer::compare );
    assertEquals( expectedSortedList, sortedList,
        "The sorted list should match the expected sorted list after sorting a reverse sorted list." );
  }

  @Test
  void test_bubbleSort_withAllEqualElements() {
    List<Integer> equalElementsList = Arrays.asList( 1, 1, 1, 1, 1 );
    List<Integer> sortedList = SortingEngine.bubbleSort( equalElementsList, Integer::compare );
    assertEquals( equalElementsList, sortedList,
        "The sorted list should be equal to the original list with all equal elements." );
  }

  @Test
  void test_bubbleSort_withCustomComparator() {
    List<String> stringList = Arrays.asList( "banana", "apple", "cherry" );
    List<String> expectedSortedList = Arrays.asList( "apple", "banana", "cherry" );
    List<String> sortedList = SortingEngine.bubbleSort( stringList, Comparator.naturalOrder() );
    assertEquals( expectedSortedList, sortedList, "The sorted list should be sorted alphabetically." );
  }
}