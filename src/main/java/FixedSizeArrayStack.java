public class FixedSizeArrayStack {

    final int DEFAULT_CAPACITY = 10;
    protected int top = -1;
    int capacity;
    int elements[];

    public FixedSizeArrayStack() {
        capacity = DEFAULT_CAPACITY;
        elements = new int[capacity];
    }

    public FixedSizeArrayStack(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
    }

    int size() {
        return (top + 1);
    }

    boolean isEmpty() {
        return (top < 0);
    }

    boolean isFull() {
        return capacity == size();
    }

    void push(int element) {
        if( isFull()) {
            throw new RuntimeException("Full");
        }
        elements[++top] = element;
    }

    int top() {
        if( isEmpty()) {
            throw new RuntimeException("Empty");
        }
        return elements[top];
    }


    int pop() {
        int data;
        if( isEmpty()) {
            throw new RuntimeException("Empty");
        }
        data = elements[top];
        elements[top--] = Integer.MIN_VALUE;
        return data;
    }

    public static void main(String[] args) {
        int length = 16;
        final int i = length << 1;
        final int i2 = length >> 1;
        System.out.println(1<<15);
        System.out.println(i2);
    }
}
