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

class CountingSortTests {

  @Test
  void test_countingSort_withEmptyList() {
    List<Integer> emptyList = Collections.emptyList();
    List<Integer> sortedList = CountingSort.countingSort( emptyList, Integer::compare );
    assertTrue( sortedList.isEmpty(), "The sorted list should be empty." );
  }

  @Test
  void test_countingSort_withSingleElement() {
    List<Integer> singleElementList = Collections.singletonList( 1 );
    List<Integer> sortedList = CountingSort.countingSort( singleElementList, Integer::compare );
    assertEquals( singleElementList, sortedList,
        "The sorted list should be equal to the original single-element list." );
  }

  @Test
  void test_countingSort_withUnsortedList() {
    List<Integer> unsortedList = Arrays.asList( 4, 2, 5, 1, 3 );
    List<Integer> sortedList = CountingSort.countingSort( unsortedList, Integer::compare );
    assertEquals( Arrays.asList( 1, 2, 3, 4, 5 ), sortedList, "The sorted list should be sorted." );
  }

  @Test
  void test_countingSort_withCustomObject() {
    List<User> users = Arrays.asList( new User( 3, "Charlie" ), new User( 1, "Alice" ), new User( 2, "Bob" ) );
    Comparator<User> byName = Comparator.comparing( User::name );
    List<User> sortedList = CountingSort.countingSort( users, byName );
    assertEquals( Arrays.asList( new User( 1, "Alice" ), new User( 2, "Bob" ), new User( 3, "Charlie" ) ), sortedList,
        "Users should be sorted by name." );
  }

  @Test
  void test_countingSort_withNullList() {
    assertThrows( IllegalArgumentException.class, () -> CountingSort.countingSort( null, Integer::compare ) );
  }

  @Test
  void test_countingSort_withNullComparator() {
    List<Integer> list = Arrays.asList( 3, 1, 2 );
    assertThrows( IllegalArgumentException.class, () -> CountingSort.countingSort( list, null ) );
  }

  @Test
  void test_countingSort_withNegativeAndPositiveNumbers() {
    List<Integer> mixedList = Arrays.asList( -2, 3, -1, 4, 0 );
    List<Integer> sortedList = CountingSort.countingSort( mixedList, Integer::compare );
    assertEquals( Arrays.asList( -2, -1, 0, 3, 4 ), sortedList,
        "The sorted list should correctly handle a mix of negative and positive numbers." );
  }

  @Test
  void test_countingSort_withStringsInReverseOrder() {
    List<String> stringList = Arrays.asList( "banana", "apple", "cherry" );
    List<String> sortedList = CountingSort.countingSort( stringList, Comparator.reverseOrder() );
    assertEquals( Arrays.asList( "cherry", "banana", "apple" ), sortedList,
        "The sorted list should be in reverse alphabetical order." );
  }

  @Test
  void test_countingSort_withCustomObjectById() {
    List<User> users = Arrays.asList( new User( 3, "Charlie" ), new User( 1, "Alice" ), new User( 2, "Bob" ) );
    Comparator<User> byId = Comparator.comparing( User::id );
    List<User> sortedList = CountingSort.countingSort( users, byId );
    assertEquals( Arrays.asList( new User( 1, "Alice" ), new User( 2, "Bob" ), new User( 3, "Charlie" ) ), sortedList,
        "Users should be sorted by their ID." );
  }

  @Test
  void test_countingSort_withMixedCaseStrings() {
    List<String> mixedCaseList = Arrays.asList( "Banana", "apple", "Cherry" );
    List<String> sortedList = CountingSort.countingSort( mixedCaseList, String.CASE_INSENSITIVE_ORDER );
    assertEquals( Arrays.asList( "apple", "Banana", "Cherry" ), sortedList,
        "The sorted list should handle mixed case strings correctly." );
  }

  @Test
  void test_countingSort_withAllElementsSame() {
    List<Integer> sameElementsList = Arrays.asList( 1, 1, 1, 1, 1 );
    List<Integer> sortedList = CountingSort.countingSort( sameElementsList, Integer::compare );
    assertEquals( sameElementsList, sortedList,
        "The sorted list should be the same as the original when all elements are equal." );
  }
}
