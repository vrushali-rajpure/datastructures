package lists;

class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

    @Override public String toString() {
        return "{" +
            "data=" + data +
            ", next=" + next +
            '}';
    }
}

public class LinkedList {
    private ListNode headNode;
    private int length;

    public LinkedList() {
        length = 0;
    }

    @Override public String toString() {
        return "lists.LinkedList{" +
            "headNode=" + headNode +
            ", length=" + length +
            '}';
    }

    void print() {
        ListNode current = headNode;

        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    int length() {
        int length = 0;
        ListNode current = headNode;

        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    void insertAtStart(int data) {
        length++;
        ListNode newNode = new ListNode(data);
        newNode.setNext(headNode);
        headNode = newNode;
    }

    void insertAtEnd(int data) {
        length++;
        ListNode newNode = new ListNode(data);
        if (headNode == null) {
            headNode = newNode;
        } else {
            ListNode current = headNode;
            ListNode previous = current;
            while (current != null) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(newNode);
        }
    }

    void insertAtMiddle(int data, int position) {

        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }

        if (headNode == null) {
            headNode = new ListNode(data);
        } else if (position == 0) {
            insertAtStart(data);
        } else {
            length++;
            ListNode newNode = new ListNode(data);
            int index = 1;
            ListNode temp = headNode;
            while (index < position) {
                temp = temp.getNext();
                index++;
            }

            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
    }

    ListNode removeFirst() {
        ListNode temp = headNode;
        if (temp != null) {
            headNode = temp.getNext();
            temp.setNext(null);
        }
        length--;
        return temp;
    }

    ListNode removeLast() {
        if (headNode == null) {
            return null;
        }
        length--;
        final ListNode next = headNode.getNext();
        if (next == null) {

            headNode = null;
            return next;
        }
        ListNode temp = headNode;
        ListNode previousNode = headNode;
        while (temp.getNext() != null) {
            previousNode = temp;
            temp = temp.getNext();
        }
        previousNode.setNext(null);
        return temp;
    }

    ListNode remove(int position) {
        if( position < 0) {
            position = 0;
        }
        if( position > length) {
            position = length - 1;
        }

        if( headNode == null) {
            return null;
        }

        if( position == 0) {
            return removeFirst();
        } else {
            length--;
            ListNode current = headNode;
            ListNode previous = headNode;
            int index = 1;
            while (index < position) {
                index++;
                previous = current;
                current = current.getNext();
            }

            previous.setNext(current.getNext());
            current.setNext(null);

            return headNode;
        }

    }

    ListNode nthFromLast(int nthNode) {
        ListNode pTemp = headNode, pthNthNode = null;
        for(int index = 1; index < nthNode; index++){
            pTemp = pTemp.getNext();
        }

        while (pTemp != null) {
            if( pthNthNode == null) {
                pthNthNode = headNode;
            } else {
                pthNthNode = pthNthNode.getNext();
            }
            pTemp = pTemp.getNext();
        }
        if( pthNthNode != null) {
            return pthNthNode;
        }
        return null;
    }

}
