package sorting;

public class Sorting {

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);
            mergeResult(arr, l, mid, h);
        }

    }

    private void mergeResult(int[] arr, int l, int mid, int h) {
        int n1 = mid;
        int n2 = h - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        int k = 1;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
