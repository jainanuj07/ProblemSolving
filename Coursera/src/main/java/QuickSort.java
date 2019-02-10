import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    private QuickSort() {}

    private static void sort(Comparable a[]) {
      //  StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    private static void sort(Comparable a[], int lo, int hi) {
        if (lo >= hi) return;
        int partpoint = partition(a, lo, hi);
        System.out.println("partionindex= "+partpoint);
        show(a);
        sort(a, lo, partpoint - 1);
        sort(a, partpoint + 1, hi);
        assert isSorted(a,lo,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {

            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            while (less(a[lo], a[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break;

            exch(a, i, j);

        }
        exch(a, lo, j);
        return j;

    }

    private static boolean less(Comparable v, Comparable w) {
        //if(v == w) return false;
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable a[], int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a,0,a.length-1);
    }

    private static boolean isSorted(Comparable[] a , int lo , int hi) {
        for(int i=lo+1;i<=hi;i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    private static void show(Comparable[] a) {
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+"  ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
       String a[] = new String[] {"P","A","B","X","W","P","P","V","P","D","P","C","Y","Z"};
       QuickSort.sort(a);
       show(a);
       assert isSorted(a);
    }
}
