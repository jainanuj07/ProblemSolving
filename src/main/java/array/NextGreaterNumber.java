package array;

import java.util.ArrayList;
import java.util.Collections;

public class NextGreaterNumber {

    public static void nextGreater(ArrayList<Integer> num) {

        int size = num.size();
        int index=-1;
        for(int i=size-2;i>=0;i--) {
            if(num.get(i) < num.get(i+1)) {
                index = i;
                break;
            }
        }
        int min = num.get(index+1);
        int min_index = index+1;
        for(int j = index+1;j<size-1;j++) {
            if(num.get(j)<min) {
                min = num.get(j);
                min_index = j;
            }
        }
        int temp = num.get(index);
        num.set(index,num.get(min_index));
        num.set(min_index,temp);

        Collections.sort(num.subList(index+1,size));

        int n = Integer.parseInt(num.toString().replaceAll("\\D",""));
        System.out.println(n);

    }

    public static void main(String args[]) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(50);
        list.add(113);
        nextGreater(list);
    }
}
