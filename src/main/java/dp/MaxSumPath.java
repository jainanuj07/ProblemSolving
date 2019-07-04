package dp;

public class MaxSumPath {

    public static void main(String args[])
    {
        int cost[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        maxsumpath(cost,cost.length);
    }

    public static void maxsumpath(int arr[][],int n) {

        int sum[][] = new int[n][n];

        sum[0][0] = arr[0][0];

        for(int j=1;j<n;j++) {
            sum[0][j] = sum[0][j-1] + arr[0][j];
        }

        for(int j=1;j<n;j++) {
            sum[j][0] = sum[j-1][0] + arr[j][0];
        }

        for(int i=1;i<n;i++) {

            for(int j=1;j<n;j++) {

                sum[i][j] = Math.max(sum[i][j-1],sum[i-1][j]) + arr[i][j];
            }
        }

        double res = (double)sum[n-1][n-1]/(2*n-1);

        System.out.print(res);
    }
}
