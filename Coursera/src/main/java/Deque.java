import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Item data;
        Node next;
        Node pre;
    }

    public Deque()                           // construct an empty deque
    {
        head = null;
        tail = null;
    }

    public boolean isEmpty()                 // is the deque empty?
    {
        return head == null;
    }

    public int size()                        // return the number of items on the deque
    {
        return size;
    }

    public void addFirst(Item item)          // add the item to the front
    {
        if (item == null) {
            throw new NullPointerException();
        }

        size++;
        Node node = new Node();
        node.data = item;
        node.next = null;
        node.pre = null;
        if (head == null) {
            head = node;
            tail = head;
        }
        else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    public void addLast(Item item)           // add the item to the end
    {
        if (item == null) {
            throw new NullPointerException();
        }

        size++;
        Node node = new Node();
        node.data = item;
        node.next = null;
        node.pre = null;
        if (tail == null) {
            tail = node;
            head = tail;
        }
        else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }

    public Item removeFirst()                // remove and return the item from the front
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        Item result = head.data;
        if (head == tail) {
            head = tail = null;
        }
        else {
            head = head.next;
            head.pre = null;
        }
        return result;
    }

    public Item removeLast()                 // remove and return the item from the end
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        Item result = tail.data;
        if (head == tail) {
            head = tail = null;
        }
        else {
            tail = tail.pre;
            tail.next = null;
        }
        return result;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.data;
            current = current.next;
            return item;
        }
    }
}
