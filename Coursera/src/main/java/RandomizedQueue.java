import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @author <Anuj jain> Created Date :  07/02/2019
 */

public class RandomizedQueue<Item extends Object> implements Iterable<Item> {

    private Item queue[];
    private int size;

    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
        size = 0;
    }

    /**
     * Resize the Queue Capacity
     */
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = queue[i];
        }
        queue = copy;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (size == queue.length) {
            resize(2 * queue.length);
        }
        queue[size++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        int rnum = StdRandom.uniform(size);
        Item item = queue[rnum];
        queue[rnum] = queue[size - 1];
        queue[--size] = null;
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        int rnum = StdRandom.uniform(size);
        Item item = queue[rnum];
        return item;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<Item>();
    }

    private class RandomizedQueueIterator<T> implements Iterator<T> {

        private int i = size;
        private final int[] order;

        public RandomizedQueueIterator() {
            order = new int[size];
            for (int j = 0; j < size; j++) {
                order[j] = j;
            }
            StdRandom.shuffle(order);
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return (T) queue[order[--i]];
        }
    }
}

