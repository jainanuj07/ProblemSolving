package sorting;

import util.ArrayUtil;

public class BubbleSort {

    public static void bubbleSort(int arr[]) {

        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {

        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ArrayUtil.printArray(arr);
        bubbleSort(arr);
        System.out.println("After Sorting");
        ArrayUtil.printArray(arr);

    }
}
