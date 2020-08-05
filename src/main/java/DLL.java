import static java.lang.Integer.MIN_VALUE;

class DLLNode {
    int data;
    DLLNode previous;
    DLLNode next;

    public DLLNode(int data) {
        this.data = data;
        next = null;
        previous = null;
    }

    public DLLNode(int data, DLLNode previous, DLLNode next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public DLLNode setNext(DLLNode next) {
        this.next = next;
        return this;
    }

    public DLLNode setPrevious(DLLNode previous) {
        this.previous = previous;
        return this;
    }

    public DLLNode getNext() {
        return next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    @Override public String toString() {
        return "{" +
            "data=" + data +
            ", previous=" + (previous != null ? previous.data+"" : null) +
            ", next=" + (next != null ? next.data+"" : null) +
            '}';
    }
}

public class DLL {
    private DLLNode head;
    private DLLNode tail;
    int length;

    public DLL() {
        length = 0;
        head = null;
        tail = null;
    }

    @Override public String toString() {
        return "DLL{" +
            "head=" + head +
            ",\n tail=" + tail +
            ",\n length=" + length +
            '}';
    }

    void addFirst(int data) {
        DLLNode newNode = new DLLNode(data, null, head);
        if( head != null) {
            head.setPrevious(newNode);
        }
        head = newNode;
        if( tail == null) {
            tail = newNode;
        }
        length++;
    }

    void addLast(int data) {
        DLLNode newNode = new DLLNode(data, tail, null);
        if( tail != null) {
            tail.setNext(newNode);
        }
        tail = newNode;
        if( head == null) {
            head = newNode;
        }

        length++;
    }

    DLLNode deleteFirst() {
        if( length == 0) {
            throw  new RuntimeException("empty DLL");
        }
        DLLNode temp = head;
        head = head.next;
        head.previous = null;
        length--;
        return temp;
    }

    void print() {
        DLLNode current = head;

        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    DLLNode deleteLast() {
        if( length == 0) {
            throw  new RuntimeException("empty DLL");
        }
        DLLNode temp = tail;
        tail = tail.previous;
        tail.next = null;
        length--;
        temp.previous = null;
        return temp;
    }

    void insert(int data, int position) {
        if( position < 0) {
            position = 0;
        }
        if( position > length) {
            position = length;
        }

        if( head == null) {
            head = new DLLNode(data);
            tail = head;
        }
        else if( position == 0) {
            addFirst(data);
        } else if( position == length) {
            addLast(data);
        } else {
            int index = 1;
            DLLNode current = head;
            while( index < position) {
                current = current.next;
                index++;
            }
            DLLNode newNode = new DLLNode(data);
            newNode.next = current.next;
            newNode.previous = current;
            newNode.next.previous = newNode;
            current.next = newNode;

            length++;
        }
    }

    DLLNode deleteAt(int position) {
        if( position < 0) {
            position = 0;
        }
        if( position > length) {
            position = length;
        }

        if( head == null) {
            return null;
        }

        if(position == 0) {
            return deleteFirst();
        } else {
            int index = 1;
            DLLNode current = head;
            while( index < position) {
                current = current.next;
                index++;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current.next = null;
            current.previous = null;

            length--;
            return current;
        }
    }
}
