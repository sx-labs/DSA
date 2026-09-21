class Solution {
    public int pivotIndex(int[] nums) {

        // Calculate the sum of the entire array
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // Initially, nothing is on the left
        int leftSum = 0;

        // Try every index as the pivot
        for (int i = 0; i < nums.length; i++) {

            /*
             * Everything except:
             * 1. left side
             * 2. current pivot
             *
             * belongs to the right side.
             */
            int rightSum = totalSum - leftSum - nums[i];

            // Check whether left and right sums are equal
            if (leftSum == rightSum) {
                return i;
            }

            /*
             * Current pivot is no longer a pivot.
             *
             * When we move to the next index,
             * nums[i] becomes part of the LEFT side.
             */
            leftSum += nums[i];
        }

        // No pivot index found
        return -1;
    }
}