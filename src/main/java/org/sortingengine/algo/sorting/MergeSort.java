package org.sortingengine.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Provides an implementation of the Merge Sort algorithm for sorting lists. This class offers a static method to sort
 * any list of objects, given a comparator. It is designed for simplicity and educational purposes rather than optimal
 * performance.
 */
public final class MergeSort {

  /**
   * Private Constructor to prevent instantiation.
   */
  private MergeSort() {
  }

  /**
   * Sorts a given list using the Merge Sort algorithm.
   *
   * <p>This method implements Merge Sort, an efficient, stable, comparison-based, divide and conquer sorting
   * algorithm. The list is recursively divided into two halves until each sublist contains a single element. Then,
   * these sublist are repeatedly merged to produce new sorted sublist until there is only one sublist remaining. This
   * final sublist is the sorted list.</p>
   *
   * <p>This implementation includes checks for null inputs and throws an IllegalArgumentException
   * if either the list or the comparator is null. This ensures that the method operates on valid inputs.</p>
   *
   * <p><b>Time Complexity:</b> O(n log n), where n is the number of elements in the list.</p>
   * <p><b>Space Complexity:</b> O(n), due to the use of temporary arrays for merging.</p>
   *
   * <p>Note: Merge Sort is well-suited for sorting large datasets and offers significant performance
   * advantages over simpler algorithms like Bubble Sort or Insertion Sort.</p>
   *
   * @param <T>        The type of elements in the list.
   * @param list       The list to be sorted. Must not be null.
   * @param comparator The comparator to determine the order of the elements. Must not be null.
   * @return A new list containing the sorted elements of the original list.
   * @throws IllegalArgumentException if the list or comparator is null.
   */
  public static <T> List<T> mergeSort( List<T> list, Comparator<T> comparator ) {
    if( list == null ) {
      throw new IllegalArgumentException( "The list cannot be null." );
    }
    if( comparator == null ) {
      throw new IllegalArgumentException( "Comparator cannot be null." );
    }

    if( list.size() <= 1 ) {
      return new ArrayList<>( list );
    }

    int mid = list.size() / 2;
    List<T> left = mergeSort( new ArrayList<>( list.subList( 0, mid ) ), comparator );
    List<T> right = mergeSort( new ArrayList<>( list.subList( mid, list.size() ) ), comparator );

    return merge( left, right, comparator );
  }

  private static <T> List<T> merge( List<T> left, List<T> right, Comparator<T> comparator ) {
    List<T> merged = new ArrayList<>();
    int i = 0;
    int j = 0;

    while( i < left.size() && j < right.size() ) {
      if( comparator.compare( left.get( i ), right.get( j ) ) <= 0 ) {
        merged.add( left.get( i++ ) );
      } else {
        merged.add( right.get( j++ ) );
      }
    }

    while( i < left.size() ) {
      merged.add( left.get( i++ ) );
    }

    while( j < right.size() ) {
      merged.add( right.get( j++ ) );
    }

    return merged;
  }
}
