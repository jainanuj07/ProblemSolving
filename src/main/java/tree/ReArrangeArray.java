package tree;

public class ReArrangeArray {

    public static void reArrangeArray(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>=0) {

                while(arr[i]!=i && arr[i]>0) {
                    int temp = arr[arr[i]];
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int A[] = {-1, -1, 6, 1,
                9, 3, 2, -1, 4,-1};
       reArrangeArray(A);

       for(int i=0;i<A.length;i++) {
           System.out.print(A[i]+"\t");
       }


        //int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
        //int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4};
        //int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4};
        //int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4};
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int n = arr.length;

        System.out.println("Given array is ");
        printArray(arr, n);

        rearrange(arr, n);

        System.out.println("RearrangeD array is ");
        printArray(arr, n);
    }

    static void rearrange(int arr[], int n)
    {
        int outofplace = -1;

        for (int index = 0; index < n; index++)
        {
            if (outofplace >= 0)
            {
                // find the item which must be moved into the out-of-place
                // entry if out-of-place entry is positive and current
                // entry is negative OR if out-of-place entry is negative
                // and current entry is negative then right rotate
                //
                // [...-3, -4, -5, 6...] -->   [...6, -3, -4, -5...]
                //      ^                          ^
                //      |                          |
                //     outofplace      -->      outofplace
                //
                if (((arr[index] >= 0) && (arr[outofplace] < 0))
                        || ((arr[index] < 0) && (arr[outofplace] >= 0)))
                {
                    rightrotate(arr, n, outofplace, index);

                    // the new out-of-place entry is now 2 steps ahead
                    if (index - outofplace > 2)
                        outofplace = outofplace + 2;
                    else
                        outofplace = -1;
                }
            }

            // if no entry has been flagged out-of-place
            if (outofplace == -1)
            {
                // check if current entry is out-of-place
                if (((arr[index] >= 0) && ((index & 0x01)==0))
                        || ((arr[index] < 0) && (index & 0x01)==1))
                    outofplace = index;
            }
        }
    }
    static void rightrotate(int arr[], int n, int outofplace, int cur)
    {
        int tmp = arr[cur];
        for (int i = cur; i > outofplace; i--)
            arr[i] = arr[i - 1];
        arr[outofplace] = tmp;
    }
    // A utility function to print an array 'arr[]' of size 'n'
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

}
