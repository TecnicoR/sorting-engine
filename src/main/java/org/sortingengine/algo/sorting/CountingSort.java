package org.sortingengine.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Provides an implementation of the Counting Sort algorithm for sorting lists. This class offers a static method to
 * sort any list of objects, given a comparator. It is designed for simplicity and educational purposes rather than
 * optimal performance.
 */
public final class CountingSort {
  /**
   * Private Constructor to prevent instantiation.
   */
  private CountingSort() {
  }

  /**
   * Sorts a given list using an adapted version of the Counting Sort algorithm.
   *
   * <p>This method extends the traditional Counting Sort approach to work with generic types,
   * using a comparator for sorting. Instead of counting frequencies in a fixed-size array, it uses a map to count
   * occurrences of each element. The sorted list is then constructed by iterating over the map's entries, which are
   * ordered according to the comparator. This approach allows Counting Sort to be used with any sortable data
   * type.</p>
   *
   * <p>Note: This method creates a new sorted list and does not modify the original list.</p>
   *
   * <p><b>Time Complexity:</b> O(n log k + k), where n is the number of elements and k is the number of distinct
   * elements. The sorting of the map entries (which depends on the comparator) introduces a log k factor.</p>
   * <p><b>Space Complexity:</b> O(n + k), for storing the frequency map and the sorted list. The frequency map's size
   * depends on the number of distinct elements (k).</p>
   *
   * @param <T>        The type of elements in the list.
   * @param list       The list to be sorted. Must not be null.
   * @param comparator The comparator to determine the order of the elements. Must not be null.
   * @return A new list containing the sorted elements of the original list.
   * @throws IllegalArgumentException if the list or comparator is null.
   */
  public static <T> List<T> countingSort( List<T> list, Comparator<T> comparator ) {
    if( list == null ) {
      throw new IllegalArgumentException( "The list cannot be null." );
    }
    if( comparator == null ) {
      throw new IllegalArgumentException( "Comparator cannot be null." );
    }

    Map<T, Integer> frequencyMap = new TreeMap<>( comparator );
    for( T item : list ) {
      frequencyMap.put( item, frequencyMap.getOrDefault( item, 0 ) + 1 );
    }

    List<T> sortedList = new ArrayList<>();
    for( Map.Entry<T, Integer> entry : frequencyMap.entrySet() ) {
      for( int i = 0; i < entry.getValue(); i++ ) {
        sortedList.add( entry.getKey() );
      }
    }

    return sortedList;
  }
}
