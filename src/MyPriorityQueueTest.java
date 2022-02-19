import org.junit.Test;

import static org.junit.Assert.*;

public class MyPriorityQueueTest {

    @Test
    public void offer() {
        MyPriorityQueue test= new MyPriorityQueue(5);
        int[] arr = new int[]{3,55,4,6,23,455,31,323,1};
        for (int i = 0; i < arr.length; i++){
            test.offer(arr[i]);
        }
        assertEquals(1,test.peek());

    }

    @Test
    public void poll() {
        MyPriorityQueue test= new MyPriorityQueue(5);
        int[] arr = new int[]{3,55,4,6,23,455,31,323,1};
        for (int i = 0; i < arr.length; i++){
            test.offer(arr[i]);
        }
        assertEquals(1,test.poll());
        assertEquals(3,test.poll());
    }

    @Test
    public void clear() {
        MyPriorityQueue test= new MyPriorityQueue(5);
        int[] arr = new int[]{3,55,4,6,23,455,31,323,1};
        for (int i = 0; i < arr.length; i++){
            test.offer(arr[i]);
        }
        test.clear();
        assertEquals(null, test.poll());
    }

    @Test
    public void peek() {
    }

    @Test
    public void isEmpty() {
        MyPriorityQueue test= new MyPriorityQueue(5);
        int[] arr = new int[]{3,55,4,6,23,455,31,323,1};
        for (int i = 0; i < arr.length; i++){
            test.offer(arr[i]);
        }
        assertEquals(false,test.isEmpty());
        test.clear();
        assertEquals(true,test.isEmpty());
    }
}