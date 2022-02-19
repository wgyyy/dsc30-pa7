import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class dHeapTester {

    @org.junit.Test
    public void size() {
        dHeap test = new dHeap();
        test.add(1);
        assertEquals(1,test.size());
        for (int i = 2; i < 8; i++){
            test.add(i);
        }
        assertEquals(7,test.size());
        dHeap another_test = new dHeap();
        another_test.add("hello");
        assertEquals(1,another_test.size());
        dHeap mintest = new dHeap(6, 6, false);
        for (int j = 0; j < 21; j++){
            mintest.add(j);
        }
        assertEquals(21, mintest.size());
    }

    @Test(expected = NullPointerException.class)
    public void addNPE() {
        dHeap test = new dHeap();
        test.add(null);
    }

    @org.junit.Test
    public void add() {
        dHeap test = new dHeap();
        test.add(10);
        assertEquals(10, test.element());
        test.add(4);
        test.add(8);
        test.add(11);
        assertEquals(11, test.element());
        dHeap another_test=new dHeap();
        another_test.add("hello");
        assertEquals("hello", another_test.element());
        dHeap mintest = new dHeap(6, 6, false);
        for (int j = 0; j < 21; j++){
            mintest.add(j);
        }
        assertEquals(0,mintest.element());
    }

    @Test(expected = NoSuchElementException.class)
    public void removeNEE() {
        dHeap test = new dHeap();
        test.remove();
    }


    @org.junit.Test
    public void remove() {
        dHeap test = new dHeap();
        test.add(10);
        test.add(4);
        test.add(8);
        test.add(1);
        test.remove();
        assertEquals(8, test.remove());
        assertEquals(4,test.remove());
        assertEquals(1, test.remove());
        for (int i = 0; i < 15; i++){
            test.add(i);
        }
        assertEquals(14, test.remove());
        assertEquals(13,test.remove());
        assertEquals(12,test.remove());
        dHeap mintest = new dHeap(6, 6, false);
        for (int j = 0; j < 21; j++){
            mintest.add(j);
        }
        assertEquals(0, mintest.remove());
        assertEquals(1, mintest.element());

    }

    @org.junit.Test
    public void clear() {
        dHeap test = new dHeap();
        test.add(100);
        test.clear();
        assertEquals(0,test.size());
        for (int i = 0; i < 15; i++){
            test.add(i);
        }
        test.clear();
        assertEquals(0,test.size());
        dHeap another_test = new dHeap();
        another_test.add("a");
        another_test.add("b");
        another_test.add("c");
        another_test.clear();
        assertEquals(0,another_test.size());
        dHeap mintest = new dHeap(6, 6, false);
        for (int j = 0; j < 21; j++){
            mintest.add(j);
        }
        mintest.clear();
        assertEquals(0,mintest.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void elementNEE() {
        dHeap test = new dHeap();
        test.element();
    }

    @org.junit.Test
    public void element() {
        dHeap test = new dHeap();
        for (int i = 0; i < 15; i++){
            test.add(i);
        }
        assertEquals(14,test.element());
        test.remove();
        assertEquals(13,test.element());
        dHeap another_test = new dHeap();
        another_test.add("a");
        another_test.add("b");
        another_test.add("c");
        assertEquals("c", another_test.element());
        another_test.remove();
        assertEquals("b", another_test.element());
        dHeap mintest = new dHeap(6, 6, false);
        for (int j = 0; j < 21; j++){
            mintest.add(j);
        }
        assertEquals(0,mintest.element());
        for (int m=0; m<20; m++) {
            mintest.remove();
        }
        assertEquals(20,mintest.element());
    }
}