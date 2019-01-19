import java.util.HashMap;

public class TwoSums {

    public static int[] twoSum(int[] nums, int target) {
        int size = 2048;
        int[] map = new int[size];
        int length = 2047;
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = nums[i] & length;

            if (map[index] != 0) {
                return new int[]{map[index] - 1, i};
            } else {
                map[(target - index) & length] = i + 1;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

        /*public static int[] twoSum(int[] nums, int target) {
            int result[] = new int[2];
            HashMap<Integer,Integer> map = new HashMap();
            for(int i=0;i<nums.length;i++) {
                map.put(nums[i],i);
            }
            for(int j=0;j<nums.length;j++) {
                int n = target-nums[j];
                if(map.containsKey(n) && n!=nums[j] ) {
                    result[0]=j;
                    result[1]=map.get(target-nums[j]);
                    break;
                }
            }

            return result;
        }*/

        public static void main(String args[]) {
            int nums[] = new int [] {3,2,4};
            int [] result = twoSum(nums,6);
            System.out.print(result[0]+  "   "+result[1]);
        }
    }

