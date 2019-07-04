public class CountRotations {

    public static int countRotations(int arr[],int l , int h) {

        if(h < l) return 0;

        if(h==l) return l;

        int mid = l+(h-l)/2 ;

        if(mid<h && arr[mid+1] < arr[mid]) return mid+1;

        if(mid>l && arr[mid-1] > arr[mid]) return mid;

        if(arr[h] > arr[mid]) {
            return countRotations(arr,l,mid-1);
        }
        return countRotations(arr,mid+1,h);
        }
    public static void main (String[] args)
    {
        int arr[] = { 2, 3, 6, 12,15,18};
        int n = arr.length;

        System.out.println(countRotations(arr, 0, n-1));
    }
}

