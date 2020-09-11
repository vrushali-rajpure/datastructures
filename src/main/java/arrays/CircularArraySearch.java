package arrays;

/**
 * 1. [8 ,9 , 10, 2, 3, 4]
 *     1. circular array
 *     2. find the index of the element 2
 *
 *
 */
public class CircularArraySearch {
    // Function to find an element in a circularly sorted array
    public static int circularArraySearch(int[] A, int x) {
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("left:" + left + ",right:" + right+ ",mid:" + mid);

            // if key is found, return its index
            if (A[mid] == x) {
                return mid;
            }

            // if right half (A[mid..right]) is sorted and mid is not
            // the key element
            if (A[mid] <= A[right]) {
                // compare key with A[mid] and A[right] to know
                // if it lies in A[mid..right] or not
                if (A[mid] < x && x <= A[right]) {
                    // go searching in right sorted half
                    left = mid + 1;
                } else {
                    // go searching left
                    right = mid - 1;
                }
            }
            // if left half (A[left..mid]) is sorted and mid is not
            // the key element
            else {
                // compare key with A[left] and A[mid] to know
                // if it lies in A[left..mid] or not
                if (A[mid] > x && x >= A[left]) {
                    // go searching in left sorted half
                    right = mid - 1;
                } else {
                    left = mid + 1;    // go searching right
                }
            }
        }
        return -1;
    }
}
