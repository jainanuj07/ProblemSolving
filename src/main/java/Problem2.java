public class Problem2 {

    public static void main(String args[]) {

        int arr[] = new int[]{1,2,3,4,5};

        int newArr[] = new int[arr.length];

        productarr(newArr,arr);
        for(int i=0;i<newArr.length;i++)
        System.out.println(newArr[i]);
    }

    public static void productarr(int newarr[],int arr[]) {
        int total_prod=1;
        for(int i=0;i<arr.length;i++) {
            total_prod=total_prod*arr[i];
        }
        for (int i=0;i<arr.length;i++) {
            newarr[i] = total_prod/arr[i];
        }
    }
}
