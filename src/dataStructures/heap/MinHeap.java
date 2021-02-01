package dataStructures.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
    private int capacity = 16;
    private int[] heap;
    private int size;

    public MinHeap(){
        heap = new int[capacity];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Heap is empty");
        }
        return heap[0];
    }
    public int remove(){
        if(isEmpty()){
            throw new NoSuchElementException("HEap is empty");
        }
        int minItem = heap[0]; //item at 0tb index is the min item
        heap[0] = heap[size-1]; //the last item becomes the new min now we need to place it at right index.
        size--;

        heapifyDown();
        return minItem;
    }
    public void heapifyDown(){
        int index =0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index); // assume the left is smallest

            /*if right child is present and right child is less tha left then he new smallest index is
            right child index, if the parent is smaller or equal to the right child then we have the elements in right
            order, parent is smaller than both its children
             */

            if(hasRightChild(index) && getRightChild(index)<getLeftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }
            if(heap[index]<= heap[smallerChildIndex]){
                //nothing to do as the heap has elements in right order
            }else{
                //swap
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
    public void add(int val){
        ensureCapacity();
        heap[size] = val;
        size++;

        shiftUp();

    }
    public void shiftUp(){
        int childIndex = size -1;
        while(hasParent(childIndex) &&  heap[childIndex] < heap[getParentIndex(childIndex)]){
            //swap with the parent
            swap(childIndex, getParentIndex(childIndex));
            childIndex = getParentIndex(childIndex);
        }
    }
    private void ensureCapacity(){
        if(size ==  capacity){
            heap = Arrays.copyOf(heap, capacity*2);
            capacity *= 2;
        }
    }
    public void swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    public int getParentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }
    public int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }
    public int getRightChildIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }
    public boolean hasLeftChild(int parentIndex){
        return getLeftChildIndex(parentIndex) < size;
    }
    public boolean hasRightChild(int parentIndex){
        return getRightChildIndex(parentIndex)< size;
    }
    public boolean hasParent(int childIndex){
        return childIndex!=0 && getParentIndex(childIndex) >=0;
    }
    public int getLeftChild(int parentIndex){
        return heap[getLeftChildIndex(parentIndex)];
    }
    public int getRightChild(int parentIndex){
        return heap[getRightChild(parentIndex)];
    }
    public int getParent(int childIndex){
        return heap[getParentIndex(childIndex)];
    }
    public static void main(String[] args){
        MinHeap mh = new MinHeap();
        //empty
        System.out.println("Is heap empty::"+ mh.isEmpty());

        int num1 =3;
        mh.add(num1);
        System.out.println("Added "+ num1 + " to heap!" );
        System.out.println("Min element in the heap::"+ mh.peek());
        num1 =2;
        mh.add(num1);
        System.out.println("Added "+ num1 + " to heap!" );
        System.out.println("Min element in the heap::"+ mh.peek());
    }
}
