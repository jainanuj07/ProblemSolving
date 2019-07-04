
import java.util.*;

class MissingPositive {

    /* Utility function that puts all non-positive
    (0 and negative) numbers on left side of
    arr[] and return count of such numbers */
    static int segregate(int arr[], int size) {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive
                // integers
                j++;
            }
        }

        return j;
    }

    /* Find the smallest positive missing
    number in an array that contains
    all positive integers */
    static int findMissingPositive(int arr[], int size) {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for (i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }

        // Return the first index value at which
        // is positive
        for (i = 0; i < size; i++)
            if (arr[i] > 0)
                return i + 1; // 1 is added becuase indexes
        // start from 0m

        return size + 1;
    }

    /* Find the smallest positive missing
    number in an array that contains
    both positive and negative integers */
    static int findMissing(int arr[], int size) {
        // First separate positive and
        // negative numbers
        int shift = segregate(arr, size);
        int arr2[] = new int[size - shift];
        int j = 0;
        for (int i = shift; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }
        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);
    }
    // main function

    public static int firstMissingPositive(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        int size = ((nums.length) - j);

        for (int k = j + 1; k < nums.length; k++) {
            int x = Math.abs(nums[k]);
            if (x > nums.length) {
                continue;
            }
            if (nums[x] > 0) {
                nums[x] = -nums[x];
            }
        }
        int l;
        for (l = j + 1; l < nums.length; l++) {
            if (nums[l] > 0)
                break;
        }
        return l + 1;
    }

    public static int firstMissingPositive_new(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length) i++;
            else if (A[A[i] - 1] != A[i]) swap(A, i, A[i] - 1);
            else i++;
        }
        i = 0;
        while (i < A.length && A[i] == i + 1) i++;
        return i + 1;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {0, 10, 2, -10, -20};
        int arr_size = arr.length;
        //  int missing = findMissing(arr, arr_size);
        int arr1[] = {3, 4, -1, 1};

        int missing = firstMissingPositive_new(arr1);

        System.out.println("The smallest positive missing number is " +
                missing);
    }
}

