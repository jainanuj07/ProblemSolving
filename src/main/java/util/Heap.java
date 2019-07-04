package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap {

    static private int size;

    private static int parent(int pos) {
        return (pos-1) / 2;
    }

    private static int leftChild(int pos) {
        return (2 * pos);
    }

    private static int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private static boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private static void swap(List<Integer> heap, int index1, int index2) {
        int tmp;
        tmp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, tmp);
    }

    private static void maxHeapify(List<Integer> heap, int pos)
    {
        if (isLeaf(pos))
            return;

        if (heap.get(pos) < heap.get(leftChild(pos)) ||
                heap.get(pos) < heap.get(rightChild(pos))) {

            if (heap.get(leftChild(pos)) > heap.get(rightChild(pos))) {
                swap(heap, pos, leftChild(pos));
                maxHeapify(heap, leftChild(pos));
            }
            else {
                swap(heap, pos, rightChild(pos));
                maxHeapify(heap, rightChild(pos));
            }
        }
    }

    public static void insert(List<Integer> heap, int element)
    {
        heap.add(++size, element);

        int current = size;
        while (heap.get(current) > heap.get(parent(current))) {
            swap(heap, current, parent(current));
            current = parent(current);
        }
    }

    public static int extractMax(List<Integer> heap)
    {
        int element = heap.get(1);
        heap.set(1, (int)Math.ceil(element/2.0));
        maxHeapify(heap, 1);
        return element;
    }

    public static int minSum(List<Integer> num, int k) {

        List<Integer> heap = new ArrayList<>();
        size = 0;
        heap.add(0, Integer.MAX_VALUE);

        for(int i=0; i<num.size(); i++) {
            insert(heap, num.get(i));
        }

        for(int i=0; i<k; i++) {
            extractMax(heap);
        }

        int sum = 0;
        for(int i=1; i<=size; i++) {
            sum+=heap.get(i);
        }
        return sum;
    }

    public static void main(String args[]){
       Heap heap = new Heap();
       Integer arr[] = new Integer[]{10,20,7};
        System.out.println( heap.minSum(Arrays.asList(arr),4));
    }
}
