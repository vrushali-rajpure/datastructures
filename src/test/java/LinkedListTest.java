import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void test() {
        LinkedList list = new LinkedList();
        list.insertAtStart(10);

        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.insertAtMiddle(25,2);
//
        list.insertAtMiddle(26,4);
//
        list.insertAtMiddle(5,0);
//
        list.removeFirst();

//        list.removeLast();

//        list.remove(3);

        list.remove(0);
        System.out.println(list);
        final ListNode node = list.nthFromLast(2);
        System.out.println(node);
    }
}