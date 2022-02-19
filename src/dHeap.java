/*
 * Name: Gaoying Wang
 * PID:  A16131629
 */

import org.junit.Test;

import java.util.*;

/**
 * This d-ary heap class constructs a list arranged either from max to
 * min or min to max.
 * 
 * @param <T> Generic type
 */
public class dHeap<T extends Comparable<? super T>> implements dHeapInterface<T> {

    private T[] heap; // heap array
    private int d; // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // boolean to indicate whether heap is max or min

    /**
     * Initializes a binary max heap with capacity = 6
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        this.heap = (T[]) new Comparable[6];
        this.d = 6;
        this.nelems = 0;
        this.isMaxHeap = true;
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        this.heap = (T[]) new Comparable[heapSize];
        this.d = 6;
        this.nelems = 0;
        this.isMaxHeap =  true;
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        if (d < 1) {
            throw new IllegalArgumentException();
        }
        this.heap = (T[]) new Comparable[heapSize];
        this.d = d;
        this.nelems = 0;
        this.isMaxHeap = isMaxHeap;
    }

    @Override
    public int size() {
        return this.nelems;
    }

    @Override
    public void add(T data) throws NullPointerException {
        if (data == null){
            throw   new NullPointerException();
        }
        this.resize();
        this.heap[this.size()] = data;
        this.nelems++;
        bubbleUp(this.size() - 1);
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (this.size() == 0){
            throw  new NoSuchElementException();
        }
        T deleted_item = this.heap[0];
        this.heap[0] = this.heap[this.size() - 1];
        this.nelems--;
        trickleDown(0);
        return deleted_item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        this.nelems = 0;
        for (int i = 0; i < this.size(); i++) {
            this.remove();
        }
    }

    public T element() throws NoSuchElementException {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }
        T return_item = this.heap[0];
        return return_item;
    }

    private void trickleDown(int index) {
        int new_ind;
        T current = this.heap[index];
        if (this.isMaxHeap) {
            while ((index * d + 1) < this.size()) {
                new_ind = findmax(index);
                if (heap[new_ind].compareTo(current) > 0) {
                    heap[index] = heap[new_ind];
                } else {
                    break;
                }
                index = new_ind;
            }
            heap[index] = current;
        } else {
            while ((index * d + 1) < this.size()) {
                new_ind = findmin(index);
                if (heap[new_ind].compareTo(current) < 0) {
                    heap[index] = heap[new_ind];
                } else {
                    break;
                }
                index = new_ind;
            }
            heap[index] = current;
        }
    }

    private int findmax(int index){
        int max = index * d + 1;
        int x = 2;
        int current_length = index * d + x;
        while ((x <= d) && (current_length < this.size())) {
            if (heap[current_length].compareTo(heap[max]) > 0) {
                max = current_length;
            }
            x++;
            current_length = index * d + x;
        }
        return max;
    }

    private int findmin(int index){
        int min = index * d + 1;
        int x = 2;
        int current_length = index * d + x;
        while ((x <= d) && (current_length < this.size())) {
            if (heap[current_length].compareTo(heap[min]) < 0) {
                min = current_length;
            }
            x++;
            current_length = index * d + x;
        }
        return min;
    }

    private void bubbleUp(int index) {
        T current = this.heap[index];
        if (this.isMaxHeap) {
            while (index > 0 && current.compareTo(this.heap[this.parent(index)]) > 0) {
                heap[index] = heap[this.parent(index)];
                index = this.parent(index);
            }
            if (index == 0) {
                this.heap[0] = current;
            }
        } else {
            while (index > 0 && current.compareTo(this.heap[this.parent(index)]) < 0) {
                heap[index] = heap[this.parent(index)];
                index = this.parent(index);
            }
            if (index == 0) {
                this.heap[0] = current;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        if (this.size() == this.heap.length){
            T[] new_list = (T[]) new Comparable[this.size() * 2];
            for (int i = 0; i < this.size(); i++) {
                new_list[i] = this.heap[i];
            }
            this.heap = new_list;
        }
    }

    private int parent(int index) {
        return (index-1)/d;
    }

}
