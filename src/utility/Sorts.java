package utility;
import java.io.*;
import java.util.Comparator;

public class Sorts {
	//////////////////////////////////////////////////////////////////////
    // Bubble Sort algorithm for naturally comparable types
    public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
        int n = array.length;  // Get the length of the array
        
        // Outer loop iterates through the entire array
        for (int i = 0; i < n - 1; i++) {
            
            // Inner loop iterates from the beginning of the array to the unsorted portion
            for (int j = 0; j < n - i - 1; j++) {
                
                // Compare adjacent elements and swap if they are in the wrong order
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    // Overloaded Bubble Sort algorithm with custom comparator
    public static <T> void bubbleSort(T[] array, Comparator<? super T> c) {
        int n = array.length;
        boolean swapped;  // Flag to check if a swap occurred
        
        // Outer loop iterates through the entire array
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Inner loop iterates from the beginning of the array to the unsorted portion
            for (int j = 0; j < n - i - 1; j++) {
                
                // Compare adjacent elements using custom comparator and swap if they are in the wrong order
                if (c.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;  // Set flag if a swap occurred
                }
            }

            // If no swaps occurred in inner loop, array is already sorted
            if (!swapped)
                break;
        }
    }
    
    
    //////////////////////////////////////////////////////////////////////
    // Insertion Sort algorithm for naturally comparable types
    public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
        int n = array.length;  // Get the length of the array
        for (int i = 1; i < n; ++i) {  // Start from the second element (index 1)
            T key = array[i];  // The element to be compared and possibly moved
            int j = i - 1;  // Start comparing with the element before

            // Move elements of array[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;  // Place the key in its correct position
        }
    }

    // Overloaded Insertion Sort algorithm with custom comparator
    public static <T> void insertionSort(T[] array, Comparator<? super T> c) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && c.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    
    
    //////////////////////////////////////////////////////////////////////
    // Selection Sort algorithm for naturally comparable types
    public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {  // Iterate through the array
            int min_idx = i;  // Assume the current index has the smallest value

            // Find the smallest element's index in the remaining array
            for (int j = i+1; j < n; j++)
                if (array[j].compareTo(array[min_idx]) < 0)
                    min_idx = j;

            // Swap the found smallest element with the element at index i
            T temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }

    // Overloaded Selection Sort algorithm with custom comparator
    public static <T> void selectionSort(T[] array, Comparator<? super T> c) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;

            for (int j = i+1; j < n; j++)
                if (c.compare(array[j], array[min_idx]) < 0)
                    min_idx = j;

            T temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }
    
    //////////////////////////////////////////////////////////////////////
    // Merge Sort algorithm for naturally comparable types
    public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
        mergeSortHelper(array, 0, array.length - 1);  // Call helper method with initial indices
    }

    // Recursive helper method for Merge Sort
    private static <T extends Comparable<? super T>> void mergeSortHelper(T[] array, int l, int r) {
        if (l < r) {  // Base case: if left index is smaller than right index
            int m = (l+r)/2;  // Find the middle point
            mergeSortHelper(array, l, m);  // Sort first half
            mergeSortHelper(array , m+1, r);  // Sort second half
            merge(array, l, m, r);  // Merge the sorted halves
        }
    }

    // Merge two sorted sub-arrays
    @SuppressWarnings("unchecked")  // Suppress the annoying warning message for type conversion on lines 148 and 149
    private static <T extends Comparable<? super T>> void merge(T[] array, int l, int m, int r) {
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays to hold values of sub-arrays
        T[] L = (T[]) new Comparable[n1];
        T[] R = (T[]) new Comparable[n2];

        // Copy data to temporary arrays
        System.arraycopy(array, l, L, 0, n1);
        System.arraycopy(array, m + 1, R, 0, n2);

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[], if any
        while (i < n1) {
            array[k++] = L[i++];
        }

        // Copy remaining elements of R[], if any
        while (j < n2) {
            array[k++] = R[j++];
        }
    }
    
    
    //////////////////////////////////////////////////////////////////////
    // Quick Sort algorithm for naturally comparable types
    public static <T extends Comparable<? super T>> void quickSort(T[] array) {
        quickSortHelper(array, 0, array.length-1);  // Call helper method with initial indices
    }

    // Recursive helper method for Quick Sort
    private static <T extends Comparable<? super T>> void quickSortHelper(T[] array, int low, int high) {
        if (low < high) {  // Base case: if low index is smaller than high index
            int pi = partition(array, low, high);  // Partition the array
            quickSortHelper(array, low, pi-1);  // Sort elements before partition
            quickSortHelper(array, pi+1, high);  // Sort elements after partition
        }
    }

    // Partition the array using last element as pivot
    private static <T extends Comparable<? super T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];  // Pivot element at the end
        int i = (low-1);  // Index of smaller element

        // Traverse through the array and rearrange elements
        for (int j=low; j<high; j++) {
            // If current element is smaller than the pivot
            if (array[j].compareTo(pivot) < 0) {
                i++;  // Increment index of smaller element

                // Swap elements at i and j
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the element at (i+1)
        T temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;  // Return the position of the pivot
    }

    
    //////////////////////////////////////////////////////////////////////
    // sorting algorithm of choice Shell Sort
  
    // Shell Sort for naturally comparable types
    public static <T extends Comparable<? super T>> void shellSort(T[] array) {
        int n = array.length;
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    // Shell Sort with a custom comparator
    public static <T> void shellSort(T[] array, Comparator<? super T> c) {
        int n = array.length;
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j;
                for (j = i; j >= gap && c.compare(array[j - gap], temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
    
}

