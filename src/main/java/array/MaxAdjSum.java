package array;

/************

 Name:  anuj	
 DATE:  07/07/19	

 ***********/

public class MaxAdjSum {

    public static void main(String args[]) {
        MaxAdjSum m = new MaxAdjSum();
        int a[] = new int[]{3,2,7,10};
        System.out.println(m.maxadjsum(a));
    }

    public int maxadjsum(int a[]) {

        int exc[] = new int[a.length];
        int inc[] = new int[a.length];

        exc[0]=0;
        inc[0] = a[0];

        for(int i=1;i<a.length;i++) {
            exc[i] = Math.max(exc[i-1],inc[i-1]);
            inc[i] = exc[i-1]+a[i];
        }

        return Math.max(exc[a.length-1],inc[a.length-1]);
    }

}
