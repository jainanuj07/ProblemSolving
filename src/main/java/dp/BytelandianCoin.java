package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BytelandianCoin {

    public static void main(String args[]) throws Exception {
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(br.readLine()!=null) {
            int n = Integer.parseInt(br.readLine());
            int sum[] = new int[n];
            Arrays.fill(sum,-1);
            System.out.println(maxdollarDP(n,sum));
        }*/
        int n =12;
        int sum[] = new int[n+1];
        Arrays.fill(sum,-1);
        System.out.println(maxdollarDP(n,sum));
    }

    public static int maxdollar(int n) {

        if(n==0) return 0;
        if(n==1) return 1;

        return Math.max(n,(maxdollar(n/2)+maxdollar(n/3)+maxdollar(n/4)));

    }

    public static int maxdollarDP(int n,int[] sum) {


                if(n==0) return 0;
                if(n==1) return 1;

        if(sum[n] != -1){
            return sum[n];
        }
        return  sum[n] = Math.max(n,(maxdollarDP(n/2,sum)+maxdollarDP(n/3,sum)+maxdollarDP(n/4,sum)));

    }
}
