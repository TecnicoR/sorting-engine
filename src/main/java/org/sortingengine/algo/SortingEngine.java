package org.sortingengine.algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The SortingEngine class provides a comprehensive library of various sorting algorithms. It serves as a central
 * repository for sorting techniques, ranging from elementary to more advanced algorithms.
 *
 * <p>This class is designed to be a valuable educational tool for understanding and comparing the
 * mechanics and efficiencies of different sorting strategies. It can also serve as a practical reference in software
 * development, albeit with the understanding that these implementations may not be optimized for high-performance
 * scenarios.</p>
 *
 * <p>Each sorting method in this class is implemented as a static method. This design choice
 * allows for easy access and utilization of the sorting algorithms. The sorting methods operate on {@code List} objects
 * from the Java Collections framework. They return a new sorted list, preserving the original list's order. This
 * feature enhances the functionality by allowing flexible use with different types of lists and custom comparison logic
 * via a {@code Comparator}.</p>
 *
 * <h2>Sorting Algorithms Included:</h2>
 * <ul>
 *     <li>Bubble Sort</li>
 *     <li>Selection Sort</li>
 *     <li>Insertion Sort</li>
 *     <li>Merge Sort</li>
 *     <li>Quick Sort</li>
 *     <li>Heap Sort</li>
 *     <li>Shell Sort</li>
 *     <li>Counting Sort</li>
 *     <li>Radix Sort</li>
 *     <li>Bucket Sort</li>
 * </ul>
 *
 * <p>Each sorting method accepts a {@code List<T>} and a {@code Comparator<T>} as arguments,
 * returning a new {@code List<T>} that is sorted according to the specified comparator.
 * This approach ensures that the original list remains unchanged.</p>
 *
 * <p><b>Note:</b> The implementations provided here are primarily for educational purposes.
 * They may not be the most efficient in terms of performance for large datasets or production
 * environment use.</p>
 */
public class SortingEngine {
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
   *                   list.
   * @param comparator A {@code Comparator} to determine the order of the elements. It allows the sorting order to be
   *                   customized.
   * @return A new list containing the sorted elements of the original list.
   */
  public static <T> List<T> bubbleSort( List<T> list, Comparator<T> comparator ) {
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
