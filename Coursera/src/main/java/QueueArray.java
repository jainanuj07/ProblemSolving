import java.util.Iterator;

/**
 *
 * @author  <Anuj jain>
 * Created Date :  07/02/2019
 */

public class QueueArray<T> implements Iterable<T> {

    private T queue[];
    private int count;
    private int first, last;

    /**
     * @param capacity
     * initialize an Queue with initial capacity
     */
    public QueueArray(int capacity) {
        queue = (T[]) new Object[capacity];
        count = 0;
        first = 0;
        last = 0;
    }

    /**
     *
     * @param capacity
     * Resize the Queue Capcity
     */
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < queue.length; i++) {
            copy[i] = queue[(first + i) % queue.length];
        }
        queue = copy;
        first = 0;
        last = count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void enqueue(T item) {
        if (count == queue.length) {
            resize(2 * queue.length);
        }
        queue[last++] = item;
        if (last == queue.length) {
            last = 0;
        }
        count++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        T item = queue[first];
        queue[first]=null;
        first++;
        count--;
        if (first == queue.length) {
            first = 0;
        }
        if(count>0 && count == queue.length/4) {
            resize(queue.length/2);
        }
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueArrayIterator();
    }

    private class QueueArrayIterator<T> implements Iterator<T> {

        int start = 0;
        @Override
        public boolean hasNext() {
            return start < count;
        }

        @Override
        public T next() {
            T item = (T) queue[(start + first) % queue.length];
            start++;
            return item;
        }
    }
}

