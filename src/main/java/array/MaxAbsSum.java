package array;

/***
 * Date : July,4,2019
 *
 *

 You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

 For example,

 A=[1, 3, -1]

 f(1, 1) = f(2, 2) = f(3, 3) = 0
 f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

 So, we return 5.


 1. (a[i]+i) - (a[j]+j)
 2. (a[j]-j) - (a[i]-i)
 3. (a[i]-i) - (a[j]-j)
 4. (a[j]+j) - (a[i]+i)

 1 and 4 are same
 2 and 3 are same

 so max a[i]+i
 min a[i]+i
 max a[i]-i
 min a[i]-i
 */

public class MaxAbsSum {

    public int maxAbsSum(int a[]) {

        int size = a.length;
        int maxs =Integer.MIN_VALUE, maxm = Integer.MIN_VALUE , mins = Integer.MAX_VALUE, minm = Integer.MAX_VALUE;

        for(int i =0 ;i < size ; i++) {

            maxs = Math.max(maxs, a[i] + i);
            mins = Math.min(mins, a[i] + i);
            maxm = Math.max(maxm, a[i] - i);
            minm = Math.min(minm, a[i] - i);
        }

        int s1 = maxs - mins;
        int s2 = maxm - minm;

        return Math.max(s1,s2);
    }

    public static void main(String args[]) {
        int[] a = new int[] {1,3,-1};
        MaxAbsSum m = new MaxAbsSum();
        System.out.println(m.maxAbsSum(a));
    }

}

