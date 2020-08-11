package sorting;

import java.util.Arrays;

public class MaxHeap {

    int[] harr;
    int heap_size;
    int capacity;

    public MaxHeap(int[] harr, int heap_size, int capacity) {
        this.harr = harr;
        this.heap_size = heap_size;
        this.capacity = capacity;
    }

    // Driver code
    public static void main(String args[]) {
        int len[] = {31, 10, 16, 9, 8, 14, 12, 3, 1, 5};
        int size = len.length;

        MaxHeap maxHeap = new MaxHeap(len, size, 16);

        System.out.println("------Remove-------------");
//        maxHeap.removeMax();

        System.out.println(Arrays.toString(maxHeap.harr));

        System.out.println("------Insert-------------");
        maxHeap.insertKey(19);

        System.out.println(Arrays.toString(maxHeap.harr));
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    int removeMax() {
        if (heap_size <= 0) {
            return Integer.MAX_VALUE;
        }
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }

        int root = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        heapify(0);
        return root;
    }

    private void heapify(int index) {
        int leftIndex = left(index);
        int rightIndex = right(index);

        int swapIndex = index;
        if (leftIndex < heap_size && harr[leftIndex] > harr[index]) {
            swapIndex = leftIndex;
        }

        if (leftIndex < heap_size && harr[rightIndex] > harr[swapIndex]) {
            swapIndex = rightIndex;
        }
        if (swapIndex != index) {
            swap(index, swapIndex);
            heapify(swapIndex);
        }
    }

    private void swap(int index, int swapIndex) {
        int temp = harr[swapIndex];
        harr[swapIndex] = harr[index];
        harr[index] = temp;
    }

    void insertKey(int key) {
        if (heap_size == capacity) {
            System.out.println("Overflow: Could not insertKey");
            return;
        }

        int insertIndex = heap_size;
        harr[heap_size] = key;
        heap_size++;

        while (insertIndex > 0 && harr[parent(insertIndex)] < key) {
            swap(insertIndex, parent(insertIndex));
            insertIndex = parent(insertIndex);
        }
    }
}
