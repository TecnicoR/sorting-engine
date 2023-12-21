package org.sortingengine.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Provides an implementation of the Bubble Sort algorithm for sorting lists. This class offers a static method to sort
 * any list of objects, given a comparator. It is designed for simplicity and educational purposes rather than optimal
 * performance.
 */
public final class BubbleSort {

  /**
   * Private Constructor to prevent instantiation.
   */
  private BubbleSort() {
  }

  /**
   * Sorts a given list using the optimized Bubble Sort algorithm.
   *
   * <p>This method implements Bubble Sort, a simple comparison-based sorting algorithm.
   * The algorithm works by repeatedly stepping through the list, comparing each pair of adjacent items and swapping
   * them if they are in the wrong order. This process is repeated until no more swaps are needed, indicating that the
   * list is sorted.</p>
   *
   * <p>An optimization is applied to the traditional Bubble Sort algorithm: if during a
   * pass through the list no elements are swapped, it indicates that the list is already sorted, and the algorithm
   * terminates early. This optimization improves performance on nearly sorted lists.</p>
   *
   * <p>This method checks if the input list and comparator are not null and throws an IllegalArgumentException
   * if either is null. This preemptive check ensures that the method operates on valid inputs.</p>
   *
   * <p><b>Time Complexity:</b> The average and worst-case time complexities are both O(n^2),
   * where n is the number of elements in the list. In the best-case scenario, when the list is already sorted, the time
   * complexity is O(n) due to the early termination optimization.</p>
   *
   * <p><b>Space Complexity:</b> The space complexity is O(n) due to the creation of a new list
   * that is a copy of the original list. If the original list needs to be sorted in place, the space complexity can be
   * reduced to O(1).</p>
   *
   * <p>Note: While Bubble Sort is intuitive and simple, it is not suitable for large data
   * sets as its average and worst-case time complexity are both O(n^2).</p>
   *
   * @param <T>        The type of elements in the list. This allows the method to be used with any object that can be
   *                   compared using a {@code Comparator}.
   * @param list       The list to be sorted. The original list remains unmodified as the method returns a new sorted
   *                   list. The method throws an IllegalArgumentException if the list is null.
   * @param comparator A {@code Comparator} to determine the order of the elements. It allows the sorting order to be
   *                   customized. The method throws an IllegalArgumentException if the comparator is null.
   * @return A new list containing the sorted elements of the original list.
   */
  public static <T> List<T> bubbleSort( List<T> list, Comparator<T> comparator ) {
    if( list == null ) {
      throw new IllegalArgumentException( "The list cannot be null." );
    }
    if( comparator == null ) {
      throw new IllegalArgumentException( "Comparator cannot be null." );
    }

    List<T> sortedList = new ArrayList<>( list ); // Create a copy of the list to avoid modifying the original
    boolean swapped;
    int n = sortedList.size();

    for( int i = 0; i < n - 1; i++ ) {
      swapped = false;
      for( int j = 0; j < n - i - 1; j++ ) {
        // Compare adjacent elements
        if( comparator.compare( sortedList.get( j ), sortedList.get( j + 1 ) ) > 0 ) {
          // Swap if they are in the wrong order
          T temp = sortedList.get( j );
          sortedList.set( j, sortedList.get( j + 1 ) );
          sortedList.set( j + 1, temp );
          swapped = true;
        }
      }
      // If no two elements were swapped, the list is already sorted
      if( !swapped ) {
        break;
      }
    }
    return sortedList;
  }
}
