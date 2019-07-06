package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/************

 Name:  anuj	
 DATE:  06/07/19

 ***********/


public class RandomStructure<V> {

    Map<V,Integer> map = new HashMap();
    ArrayList<V> list = new ArrayList<>();

    public void insert(V val) {
        if(!map.containsKey(val)) {
            list.add(val);
            map.put(val,list.indexOf(val));
        }
    }

    public boolean isExist(V val) {
        if(map.containsKey(val)) {
            return true;
        }
        return false;
    }

    public void delete(V val) {
        if(isExist(val)) {
            int index = map.get(val);
            map.remove(val);
            list.set(index,list.get(list.size()-1));
            list.remove(list.size()-1);
        }
    }

    public void print() {
        System.out.println("print list------");
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        System.out.println("print map------");

        for(Map.Entry<V,Integer>entry: map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public V getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        System.out.println(rand);
        return list.get(index);
    }

    public static void main(String args[]) {
        RandomStructure<Integer> r = new RandomStructure<>();
        r.insert(10);
        System.out.println(r.isExist(10));
        System.out.println(r.isExist(20));
        r.insert(20);
        r.insert(5);
        r.insert(60);
        System.out.println(r.getRandom());
        r.delete(5);
        System.out.println(r.getRandom());
    }

}
