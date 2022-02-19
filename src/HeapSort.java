/*
 * Name: Gaoying Wang
 * PID:  A16131629
 */

/**
 * This class uses the min-heap to sort an array in ascending order.
 */
public class HeapSort {

    /**
     * Initializes a min-heap and uses the min-heap to sort the given array
     * from the start index to the end index inclusively.
     *
     * @param arr the given array to be sorted.
     * @param start the start index
     * @param end the end index
     */
    public static void heapSort(int[] arr, int start, int end) {
        dHeap<Integer> min_heap=new dHeap<Integer>(6,6,false);
        for (int i = start; i <= end; i++){
            min_heap.add(arr[i]);
        }
        for (int j = start; j <= end; j++){
            arr[j] = min_heap.remove();
        }
    }
}
