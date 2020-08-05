import org.junit.Test;

import static org.junit.Assert.*;

public class SortingTest {

    @Test
    public void mergeSort() {
        int arr[] = {12, 11, 13, 5, 6, 7};

        Sorting ob = new Sorting();
        System.out.println("Given Array");
        ob.printArray(arr);

        ob.mergeSort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        ob.printArray(arr);
    }
}