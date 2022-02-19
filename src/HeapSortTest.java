import org.junit.Test;

import static org.junit.Assert.*;

public class HeapSortTest {

    @Test
    public void heapSort() {
        HeapSort test= new HeapSort();
        int[] arr = new int[]{3,55,4,6,23,455,31,323,1};
        HeapSort.heapSort(arr,1,4);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}