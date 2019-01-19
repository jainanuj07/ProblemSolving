import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        /*Arrays.sort(nums);

        List<Integer> result = new ArrayList<Integer>(2); //1,1,1,2,2,3
        int count[] = new int[2];
        int count1=1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]!=nums[i-1]) {
                result.add(nums[i-1]);
                count[0]=count1;
                count1=1;
            }
            if(i==nums.length && count[1]==0) {
                count[1]=count1;
                result.add(nums[i-1]);
            }
            count1++;
        }

*/
        HashMap<Integer,Integer> map = new HashMap<>();

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((n1,n2) ->  map.get(n1) - map.get(n2));

       /* SortedMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return s2.compareTo(s1);
            }
        });
*/

        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                int val = map.get(nums[i])+1;
                map.put(nums[i],val);
            }
            else {
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
            if (queue.size() >k) {
                queue.poll();
            }
        }

        System.out.println(queue);


        return null;
    }



    public static void main(String args[]) {

        int nums [] = new int[] {1,1,1,2,2,3,3,3,3};
        int k = 2;

        System.out.println(topKFrequent(nums,k));

    }






       /* SortedMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return s2.compareTo(s1);
            }
        });



        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            sortedMap.put(entry.getValue(),entry.getKey());
        }

        int j=0;
        List<Integer> list = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry : sortedMap.entrySet()) {
            if(j==k)
                break;
            list.add(entry.getValue());
            j++;

        }
        return list;
    }*/

}
