package arrays.solutions.medium;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicateInArrayIII {

    public int removeDuplicates(int[] nums) {
//
//        int count = 0;
//        for (int j = 1; j < nums.length; j++) {
//             if( nums[j] != nums[count]) {
//                 count++;
//                 if( j > count + 1){
//                     nums[count + 1] = nums[j];
//                     count++;
//                 }
//             }
//        }
//        return count + 1;

//        int i = 0;
//        while ( i < nums.length) {
//            int j = i+1;
//            int count = 1;
//            while ( j < nums.length){
//                if( nums[i] == nums[j]){
//                    count += 1;
//
//                    if( count > 2) {
//                        for (int k = j + 1; k < arr; k++) {
//
//                        }
//                    }
//                } else {
//                    break;
//                }
//                j++;
//            }
//            if( count > 2) {
//
//                for (int k =  j ; k < nums.length  ; k++, count--){
//                    if( count == 2) {
//                        break;
//                    }
//                    nums[i+2] = nums[k];
//                    i++;
//                }
//            } else {
//                i = i + count;
//            }
//
//        }
        return 0;
    }

    private int[] remElement(int[] arr, int index) {

        //
        // Overwrite the element at the given index by
        // moving all the elements to the right of the
        // index, one position to the left.
        //
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        return arr;
    }

    public int removeDuplicatesSol(int[] nums) {

        // Initialize the counter and the array index.
        int i = 1, count = 1, length = nums.length;

        //
        // Start from the second element of the array and process
        // elements one by one.
        //
        while (i < length) {

            //
            // If the current element is a duplicate,
            // increment the count.
            //
            if (nums[i] == nums[i - 1]) {

                count++;

                //
                // If the count is more than 2, this is an unwanted duplicate element
                // and hence we remove it from the array.
                //
                if (count > 2) {

                    this.remElement(nums, i);

                    //
                    // Note that we have to decrement the array index value to
                    // keep it consistent with the size of the array.
                    //
                    i--;

                    //
                    // Since we have a fixed size array and we can't actually
                    // remove an element, we reduce the length of the array as
                    // well.
                    //
                    length--;
                }
            } else {

                //
                // Reset the count since we encountered a different element
                // than the previous one.
                //
                count = 1;
            }

            // Move on to the next element in the array
            i++;
        }

        return length;
    }
}
