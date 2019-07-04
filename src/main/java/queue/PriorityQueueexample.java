package queue;

import java.util.PriorityQueue;

public class PriorityQueueexample {

    public static void main(String args[])
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(100);
        pq.add(50);
        pq.add(10);
        pq.add(200);
        pq.add(150);

    while(!pq.isEmpty()) {
        System.out.println(pq.remove());
    }
    }

}
