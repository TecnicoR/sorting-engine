package org.sortingengine.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Provides an implementation of the Insertion Sort algorithm for sorting lists. This class offers a static method to
 * sort any list of objects, given a comparator. It is designed for simplicity and educational purposes rather than
 * optimal performance.
 */
public final class InsertionSort {
  /**
   * Private Constructor to prevent instantiation.
   */
  private InsertionSort() {
  }

  /**
   * Sorts a given list using the Insertion Sort algorithm.
   *
   * <p>This method implements Insertion Sort, a comparison-based sorting algorithm.
   * It builds the final sorted list one item at a time. The algorithm iterates through the list, and for each element,
   * it finds the correct position in the already sorted part of the list and inserts it there.</p>
   *
   * <p>This implementation includes checks for null inputs and throws an IllegalArgumentException
   * if either the list or the comparator is null. This ensures that the method operates on valid inputs.</p>
   *
   * <p><b>Time Complexity:</b> The average and worst-case time complexities are O(n^2),
   * where n is the number of elements in the list. However, in the best-case scenario, when the list is already or
   * nearly sorted, the complexity is O(n).</p>
   *
   * <p><b>Space Complexity:</b> O(n) due to the creation of a new list that is a copy
   * of the original list. The original list remains unmodified.</p>
   *
   * <p>Note: Insertion Sort is effective for small datasets and nearly sorted lists but
   * is inefficient for larger, unsorted datasets.</p>
   *
   * @param <T>        The type of elements in the list.
   * @param list       The list to be sorted. Must not be null.
   * @param comparator The comparator to determine the order of the elements. Must not be null.
   * @return A new list containing the sorted elements of the original list.
   * @throws IllegalArgumentException if the list or comparator is null.
   */
  public static <T> List<T> insertionSort( List<T> list, Comparator<T> comparator ) {
    if( list == null ) {
      throw new IllegalArgumentException( "The list cannot be null." );
    }
    if( comparator == null ) {
      throw new IllegalArgumentException( "Comparator cannot be null." );
    }

    List<T> sortedList = new ArrayList<>( list );
    for( int i = 1; i < sortedList.size(); i++ ) {
      T current = sortedList.get( i );
      int j = i - 1;

      while( j >= 0 && comparator.compare( sortedList.get( j ), current ) > 0 ) {
        sortedList.set( j + 1, sortedList.get( j ) );
        j--;
      }
      sortedList.set( j + 1, current );
    }
    return sortedList;
  }
}
