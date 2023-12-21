package org.sortingengine.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Provides an implementation of the Quick Sort algorithm for sorting lists. This class offers a static method to sort
 * any list of objects, given a comparator. It is designed for simplicity and educational purposes rather than optimal
 * performance.
 */
public final class QuickSort {
  /**
   * Private Constructor to prevent instantiation.
   */
  private QuickSort() {
  }

  /**
   * Sorts a given list using the Quick Sort algorithm.
   *
   * <p>This method implements Quick Sort, a highly efficient, comparison-based, divide and conquer sorting algorithm.
   * It selects a 'pivot' element from the list and partitions the other elements into two sub-lists, according to
   * whether they are less than or greater than the pivot. The sub-lists are then recursively sorted. This
   * implementation chooses the pivot as the median of the first, middle, and last elements to improve performance on
   * sorted and nearly sorted data.</p>
   *
   * <p>This implementation includes checks for null inputs and throws an IllegalArgumentException
   * if either the list or the comparator is null. This ensures that the method operates on valid inputs.</p>
   *
   * <p><b>Time Complexity:</b> Average case O(n log n), with worst-case O(n^2), particularly when the list is already
   * sorted or nearly sorted (mitigated here by using median-of-three pivot selection).</p>
   * <p><b>Space Complexity:</b> O(log n) due to recursive stack space.</p>
   *
   * <p>Note: Quick Sort is suitable for large datasets and generally performs better than simpler algorithms like
   * Bubble Sort or Insertion Sort, especially with random or varied data.</p>
   *
   * @param <T>        The type of elements in the list.
   * @param list       The list to be sorted. Must not be null.
   * @param comparator The comparator to determine the order of the elements. Must not be null.
   * @return A new list containing the sorted elements of the original list.
   * @throws IllegalArgumentException if the list or comparator is null.
   */
  public static <T> List<T> quickSort( List<T> list, Comparator<T> comparator ) {
    if( list == null ) {
      throw new IllegalArgumentException( "The list cannot be null." );
    }
    if( comparator == null ) {
      throw new IllegalArgumentException( "Comparator cannot be null." );
    }

    List<T> sortedList = new ArrayList<>( list );
    quickSortRecursive( sortedList, 0, sortedList.size() - 1, comparator );
    return sortedList;
  }

  private static <T> void quickSortRecursive( List<T> list, int start, int end, Comparator<T> comparator ) {
    if( start < end ) {
      int pivotIndex = partition( list, start, end, comparator );
      quickSortRecursive( list, start, pivotIndex - 1, comparator );
      quickSortRecursive( list, pivotIndex, end, comparator ); // Changed to 'pivotIndex' from 'pivotIndex + 1'
    }
  }

  private static <T> int partition( List<T> list, int start, int end, Comparator<T> comparator ) {
    // Choosing the middle element as pivot for better performance
    T pivot = list.get( start + ( end - start ) / 2 );
    int i = start;
    int j = end;
    while( i <= j ) {
      // Move i and j towards each other, swapping elements to correct sides of pivot
      while( comparator.compare( list.get( i ), pivot ) < 0 )
        i++;
      while( comparator.compare( list.get( j ), pivot ) > 0 )
        j--;
      if( i <= j ) {
        swap( list, i, j );
        i++;
        j--;
      }
    }
    return i;
  }

  private static <T> void swap( List<T> list, int i, int j ) {
    T temp = list.get( i );
    list.set( i, list.get( j ) );
    list.set( j, temp );
  }
}
