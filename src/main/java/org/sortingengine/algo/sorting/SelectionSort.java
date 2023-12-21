package org.sortingengine.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Provides an implementation of the Selection Sort algorithm for sorting lists. This class offers a static method to
 * sort any list of objects, given a comparator. It is designed for simplicity and educational purposes rather than
 * optimal performance.
 */
public class SelectionSort {

  /**
   * Private Constructor to prevent instantiation.
   */
  private SelectionSort() {
  }

  /**
   * Sorts a given list using the Selection Sort algorithm.
   *
   * <p>This method implements Selection Sort, a simple comparison-based sorting algorithm.
   * The algorithm divides the input list into two parts: the sorted part at the beginning of the list and the unsorted
   * part at the rest of the list. Initially, the sorted part is empty, and the unsorted part is the entire list. The
   * algorithm repeatedly finds the smallest (or largest, depending on the comparator) element from the unsorted part
   * and moves it to the end of the sorted part.</p>
   *
   * <p>While not suitable for large datasets due to its O(n^2) time complexity, Selection
   * Sort is intuitive and performs well on small lists.</p>
   *
   * <p><b>Time Complexity:</b> O(n^2), where n is the number of elements in the list.</p>
   * <p><b>Space Complexity:</b> O(n) for creating a new list. Can be optimized to O(1) if sorting in place.</p>
   *
   * @param <T>        The type of elements in the list.
   * @param list       The list to be sorted.
   * @param comparator A {@code Comparator} to determine the order of the elements.
   * @return A new list containing the sorted elements of the original list.
   */
  public static <T> List<T> selectionSort( List<T> list, Comparator<T> comparator ) {
    if( list == null ) {
      throw new IllegalArgumentException( "The list cannot be null." );
    }
    if( comparator == null ) {
      throw new IllegalArgumentException( "Comparator cannot be null." );
    }
    List<T> sortedList = new ArrayList<>( list ); // Create a copy of the list
    int n = sortedList.size();

    for( int i = 0; i < n - 1; i++ ) {
      // Find the minimum element in unsorted array
      int minIdx = i;
      for( int j = i + 1; j < n; j++ ) {
        if( comparator.compare( sortedList.get( j ), sortedList.get( minIdx ) ) < 0 ) {
          minIdx = j;
        }
      }

      // Swap the found minimum element with the first element
      T temp = sortedList.get( minIdx );
      sortedList.set( minIdx, sortedList.get( i ) );
      sortedList.set( i, temp );
    }
    return sortedList;
  }
}
