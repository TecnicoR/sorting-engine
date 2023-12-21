# Sorting Algorithms in Java

This repository contains a collection of classic sorting algorithms implemented in Java. Each algorithm is meticulously
implemented and accompanied by comprehensive test coverage. The source code for these implementations can be found in
the `src/main` folder, and their respective tests are available in the same directory structure.

## Algorithms Included

Below is a list of the sorting algorithms provided in this repository along with a detailed explanation of each.

### 1. Bubble Sort

Bubble Sort is a simple comparison-based algorithm. It works by repeatedly stepping through the list, comparing adjacent
elements and swapping them if they are in the wrong order. The pass through the list is repeated until the list is
sorted.

#### Enhanced Explanation of Bubble Sort

Bubble Sort is one of the simplest sorting algorithms. It is a comparison-based algorithm in which each pair of adjacent
elements is compared, and the elements are swapped if they are not in the right order. This process is repeated until no
more swaps are needed, indicating that the list is sorted.

#### How Bubble Sort Works

1. **Starting from the first element**: The algorithm starts at the beginning of the dataset and compares the first two
   elements.
2. **Comparing and Swapping**: If the first element is greater than the second (in ascending order sorting), the two
   elements are swapped. This process continues for each pair of adjacent elements till the end of the data set.
3. **Repeated Passes**: After the first pass, the largest element gets bubbled up to the last position. The algorithm
   then repeats the process for the remaining elements, excluding the last sorted elements in each pass.
4. **Optimization**: The algorithm can be optimized by stopping the process if no swaps are made in a pass, which means
   the list is already sorted.

#### Visual Representation of Bubble Sort

![Bubble Sort Diagram](https://www.researchgate.net/profile/Potturi-Reshma-2/publication/348959084/figure/fig1/AS:986621331652608@1612240264456/Working-procedure-of-Bubble-Sort.ppm)

### 2. Counting Sort

Counting Sort is an integer sorting algorithm. Unlike traditional comparison-based algorithms, it operates by counting
the number of objects that possess distinct key values and using arithmetic to determine the positions of each key value
in the output sequence.

### 3. HeapSort

HeapSort is a comparison-based sorting technique based on a Binary Heap data structure. It's similar to selection sort
where we first find the maximum element and place it at the end. We repeat the same process for the remaining elements.

### 4. Insertion Sort

Insertion Sort is a simple sorting algorithm that builds the final sorted array one item at a time. It is much less
efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.

### 5. Merge Sort

Merge Sort is an efficient, stable, comparison-based, divide and conquer sorting algorithm. Most implementations produce
a stable sort, meaning that the order of equal elements is the same in the input and output.

### 6. QuickSort

QuickSort is an efficient sorting algorithm, serving as a systematic method for placing the elements of an array in
order. It works on the divide and conquer principle. QuickSort is faster in practice than other O(n log n) algorithms
like Bubble Sort or Merge Sort.

### 7. Selection Sort

Selection Sort is a simple comparison-based algorithm. The algorithm divides the input list into two parts: a sorted
sublist of items which is built up from left to right and a sublist of the remaining unsorted items.

## Getting Started

To run these algorithms, simply clone the repository and navigate to the `src/main` directory. You'll find each sorting
algorithm in its separate file, with a clear and consistent coding style.

## Running the Tests

Tests for each sorting algorithm are provided to ensure their correct functionality. Navigate to the test directory to
view or run these tests. They are crucial for maintaining the integrity of the algorithms.

## Contributing

Contributions to this repository are welcome. Feel free to fork the repo, make changes, and submit a pull request.

Happy Sorting!
