package array;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SpiralMatrixPrint {

    public static void main(String args[]) {
        int arr[][] = new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11},
        };
        SpiralMatrixPrint s = new SpiralMatrixPrint();
        s.printSpiral(arr);

    }

    public void printSpiral(int a[][]) {
        int row = a.length;
        int col = a[0].length;
        int up = 0;
        int left = 0;

        while (up < row && left < col) {
            for (int i = left; i < col; i++) {
                System.out.println(a[up][i]);
            }
            up++;

            for (int i = up; i < row; i++) {
                System.out.println(a[i][col - 1]);
            }
            col--;

            if (up < row) {
                for (int i = col - 1; i >= left; i--) {
                    System.out.println(a[row - 1][i]);
                }
            }
            row--;

            if (left < col) {
                for (int i = row - 1; i >= up; i--) {
                    System.out.println(a[i][left]);
                }
            }
            left++;
        }

    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {

        int up = 0;
        int left = 0;
        int row = A;
        int col = A;
        int num = 1;

        // ArrayList<ArrayList<Integer>> res = new ArrayList();
        int res[][] = new int[A][A];
        while (left < col && up < row) {

            for (int i = left; i < col; i++) {
                res[up][i] = num;
                num++;
            }
            up++;

            for (int i = up; i < row; i++) {
                res[i][col - 1] = num;
                num++;
            }
            col--;

            if (up < row) {
                for (int i = col - 1; i >= left; i--) {
                    res[row - 1][i] = num;
                    num++;
                }
            }
            row--;

            if (left < col) {
                for (int i = row - 1; i >= up; i--) {
                    res[i][left] = num;
                    num++;
                }
            }
            left++;
        }

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
        return null;
    }


}
