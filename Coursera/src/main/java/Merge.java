import edu.princeton.cs.algs4.StdIn;

public class Merge {

    public  void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // assert isSorted(a,lo,mid);
        // assert isSorted(a,mid+1,hi);
        int i = lo;
        int j = mid + 1;
        int k = 0;

        for (k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            }
           else if (j > hi) {
                a[k] = aux[i++];
            }

           else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }

        }

    }

    public boolean less(Comparable v , Comparable w) {
        return v.compareTo(w) < 0 ;
    }

    public static void main(String[] args) {
        Merge m = new Merge();

        Comparable v [] = new Comparable[] { 5,7,9 ,1, 2, 10};

        Comparable[] auxa = new Comparable[v.length];

        int mid = (v.length-1)/2;

        m.merge(v,auxa,0,mid,v.length-1);

        for(int i =0;i<v.length;i++) {
            System.out.println(v[i]);
        }
    }
}
