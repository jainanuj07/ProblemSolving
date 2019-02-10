import java.util.Iterator;

public class QueueArrayTest {
    public static void main(String args[]) {

        QueueArray<Integer> deq2 = new QueueArray<Integer>(10);

        deq2.enqueue(1);
        deq2.enqueue(2);
        deq2.enqueue(3);
        deq2.enqueue(4);
        deq2.enqueue(5);
        deq2.enqueue(6);
        deq2.enqueue(7);
        deq2.enqueue(8);
        deq2.enqueue(9);
        deq2.enqueue(10);

        System.out.println(deq2.dequeue());
        System.out.println(deq2.dequeue());
        System.out.println("--------------------");
        deq2.enqueue(22);
        deq2.enqueue(21);
        deq2.enqueue(20);
        deq2.enqueue(19);
        deq2.enqueue(18);
        deq2.enqueue(17);


        Iterator itr = deq2.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("--------------------");

       /* deq2.removeLast();

        itr = deq2.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("--------------------");

        deq2.removeFirst();
        deq2.removeFirst();


        itr = deq2.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("--------------------");


        deq2.removeLast();
        deq2.removeLast();

        itr = deq2.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("--------------------");

        deq2.addFirst(1);
        deq2.addLast(2);

        itr = deq2.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("--------------------");


        deq2.addFirst(3);
        deq2.addLast(4);

        itr = deq2.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("--------------------");

*/
    }
}
