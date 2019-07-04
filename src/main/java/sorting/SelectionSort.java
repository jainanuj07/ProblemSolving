package sorting;

import util.ArrayUtil;

public class SelectionSort {

    public static void selectionSort(int[] a) {
        for(int i=0;i<a.length-1;i++) {

            int min_idx = i;

            for(int j=i+1;j<a.length;j++) {

                if(a[j]<a[min_idx]) {
                    min_idx=j;
                }
            }

            int temp=a[i];
            a[i]=a[min_idx];
            a[min_idx]=temp;
        }
    }


    public static void main(String args[]) {

        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ArrayUtil.printArray(arr);
        selectionSort(arr);
        System.out.println("After Sorting");
        ArrayUtil.printArray(arr);

    }
}
