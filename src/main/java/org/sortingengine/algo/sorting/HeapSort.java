package org.sortingengine.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Provides an implementation of the Heap Sort algorithm for sorting lists. This class offers a static method to sort
 * any list of objects, given a comparator. It is designed for simplicity and educational purposes rather than optimal
 * performance.
 */
public final class HeapSort {

  /**
   * Private Constructor to prevent instantiation.
   */
  private HeapSort() {
  }

  /**
   * Sorts a given list using the Heap Sort algorithm.
   *
   * <p>This method implements Heap Sort, an efficient sorting algorithm that first transforms
   * the list into a binary heap structure and then sorts it. The largest (or smallest, depending on the comparator)
   * elements are repeatedly moved to the end of the list, and the heap size is reduced accordingly until the entire
   * list is sorted.</p>
   *
   * <p>This implementation includes null checks and throws an IllegalArgumentException
   * if either the list or the comparator is null, ensuring that the method operates on valid inputs.</p>
   *
   * <p><b>Time Complexity:</b> O(n log n), where n is the number of elements in the list.</p>
   * <p><b>Space Complexity:</b> O(1) as it sorts the list in place.</p>
   *
   * <p>Note: Heap Sort is particularly useful for datasets that are too large to fit entirely in memory.</p>
   *
   * @param <T>        The type of elements in the list.
   * @param list       The list to be sorted. Must not be null.
   * @param comparator The comparator to determine the order of the elements. Must not be null.
   * @return A new list containing the sorted elements of the original list.
   * @throws IllegalArgumentException if the list or comparator is null.
   */
  public static <T> List<T> heapSort( List<T> list, Comparator<T> comparator ) {
    if( list == null ) {
      throw new IllegalArgumentException( "The list cannot be null." );
    }
    if( comparator == null ) {
      throw new IllegalArgumentException( "Comparator cannot be null." );
    }

    // Create a copy of the original list to sort
    List<T> resultList = new ArrayList<>( list );
    int n = resultList.size();

    // Build heap
    for( int i = n / 2 - 1; i >= 0; i-- ) {
      heapify( resultList, n, i, comparator );
    }

    // Extract elements from heap one by one
    for( int i = n - 1; i >= 0; i-- ) {
      // Move current root to end
      T temp = resultList.get( 0 );
      resultList.set( 0, resultList.get( i ) );
      resultList.set( i, temp );

      // Call max heapify on the reduced heap
      heapify( resultList, i, 0, comparator );
    }

    return resultList;
  }

  private static <T> void heapify( List<T> list, int n, int i, Comparator<T> comparator ) {
    int largest = i; // Initialize largest as root
    int left = 2 * i + 1; // left = 2*i + 1
    int right = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if( left < n && comparator.compare( list.get( left ), list.get( largest ) ) > 0 ) {
      largest = left;
    }

    // If right child is larger than largest so far
    if( right < n && comparator.compare( list.get( right ), list.get( largest ) ) > 0 ) {
      largest = right;
    }

    // If largest is not root
    if( largest != i ) {
      T swap = list.get( i );
      list.set( i, list.get( largest ) );
      list.set( largest, swap );

      // Recursively heapify the affected subtree
      heapify( list, n, largest, comparator );
    }
  }
}
