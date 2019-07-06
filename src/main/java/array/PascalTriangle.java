package array;

import java.util.ArrayList;

public class PascalTriangle {

    public static void main(String args[]) {
        int arr[][] = new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11},
        };
        PascalTriangle pascalTriangle = new PascalTriangle();
        ArrayList l = pascalTriangle.pascalTriangle(5);
        System.out.println(l);
    }

    public ArrayList<ArrayList<Integer>> pascalTriangle(int A) {

        ArrayList<ArrayList<Integer>> res= new ArrayList();

        for(int i=0;i<A;i++) {
            ArrayList<Integer> rowlist= new ArrayList();
            if(i==0) {
                rowlist.add(1);
            }
            else {
                ArrayList<Integer> prev = res.get(i-1);
                rowlist.add(1);
                for (int j = 1; j < i; j++) {
                    rowlist.add(prev.get(j) + prev.get(j - 1));
                }
                rowlist.add(1);
            }
            res.add(rowlist);
        }
        return res;
    }
}
