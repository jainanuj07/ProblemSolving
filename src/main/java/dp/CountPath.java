package dp;

/************

 Name:  anuj	
 DATE:  06/07/19	
 ***********/
public class CountPath {

    public static void main(String args[]) {
        CountPath countPath = new CountPath();

        System.out.println(countPath.count(3,3));
        System.out.println(countPath.countDP(3,3));

    }

    public int count(int i,int j) {
        if(i==1 || j==1) return 1;
        return count(i-1,j) + count(i,j-1);
    }

    public int countDP(int m,int n) {
        int path[][] = new int[m][n];

        for(int i=0;i<n;i++) {
            path[0][i]=1;
        }

        for(int j=0;j<m;j++) {
            path[j][0]=1;
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }


}
