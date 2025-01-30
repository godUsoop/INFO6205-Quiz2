public class BinarySearchRotatedArray {
    /**
     * Searches for a target value in a rotated sorted array.
     *
     * @param arr            The rotated sorted array to search in
     * @param target         The value to search for
     * @param rotationIndex  The index at which the array is rotated
     * @return               The index of the target value if found, -1 otherwise
     */
    public int search(int[] arr, int target, int rotationIndex){
        //TODO
        /*
         * You have to check if the rotatedIndex is 0,
         * that means the array is not rotated at all or
         * the smallest index is at position 0.(remember the array is sorted)
         */



        if (rotationIndex == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
        }



        if (rotationIndex != 0) {
            if (arr[rotationIndex] == target) {
                return rotationIndex;
            }

            int x = arr.length - rotationIndex;
            if (arr[rotationIndex + x - 1] < target) {
                int right = arr.length - 1;
                int left = 0;
                while (left <= right) {
                    int m = left + (right - left) / 2;
                    if (arr[m] > target) {
                        right = m - 1;
                    } else if (arr[m] < target) {
                        left = m + 1;
                    } else {
                        return m;
                    }
                }

                //        int[] arr = {4, 5, 6, 7, 0, 1, 2};
//        assertEquals(6, searcher.search(arr, 2, 4));
            } else if (arr[rotationIndex + x - 1] > target) {
                int left = rotationIndex;
                int right = arr.length - 1;
                while (left <= right) {
                    int m = left + (right - left) / 2;
                    if (arr[m] > target) {
                        right = m - 1;
                    } else if (arr[m] < target) {
                        left = m + 1;
                    } else {
                        return m;
                    }
                }
            }

        }


        return -1;
        
    }

    /**
     * Performs a binary search on a sorted array within the specified range.
     *
     * @param arr     The sorted array to search in
     * @param left    The left boundary of the search range (inclusive)
     * @param right   The right boundary of the search range (inclusive)
     * @param target  The value to search for
     * @return        The index of the target value if found, -1 otherwise
     */
    private int binarySearch(int[] arr, int left, int right, int target){
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (arr[m] > target) {
                right = m - 1;
            } else if (arr[m] < target) {
                left = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}