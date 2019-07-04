package queue;

import util.ArrayUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangeChars {
    public static void main(String args[]) {

        String s = "aaabc";
        System.out.println(reArrange(s));
    }

    static class Key {
        char ch;
        int freq;

        public Key(char ch,int freq) {
            this.ch=ch;
            this.freq=freq;
        }
    }

    public static class KeyComprator implements Comparator<Key> {

        @Override
        public int compare(Key k1, Key k2) {
            if(k1.freq > k2.freq) return -1;
            else if(k1.freq < k2.freq) return 1;
            else return 0;
        }
    }


    public static String reArrange(String str) {

        int count[] = new int[26];

        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            count[ch-'a']++;
        }

        PriorityQueue<Key> pq = new PriorityQueue<Key>(new KeyComprator());

        for(char ch='a'; ch<='z';ch++) {
            int val = ch-'a';
            if(count[val]>0) {
                pq.add(new Key(ch,count[val]));
            }
        }

        ArrayUtil.printArray(count);

        StringBuilder st = new StringBuilder();
        Key prev=null;

        while(!pq.isEmpty()) {

            Key key = pq.poll();

                st.append(key.ch);

                key.freq--;

                if(prev!=null && prev.freq>0) {
                    pq.add(prev);
                }
                prev = key;

        }

        return st.toString();
    }

}
