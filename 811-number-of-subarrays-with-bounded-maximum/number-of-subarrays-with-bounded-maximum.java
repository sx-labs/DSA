class Solution {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        // We need:
        // maximum >= left AND maximum <= right
        //
        // So:
        // max in [left, right]
        // = max <= right - max <= left-1
        return count(nums, right) - count(nums, left - 1);
    }

    // Counts the number of subarrays
    // whose maximum element is <= limit
    private int count(int[] nums, int limit) {

        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            // If nums[right] is greater than limit,
            // it cannot be present in any valid subarray.
            //
            // Therefore, it becomes a barrier.
            // Start a new window after it.
            if (nums[right] > limit) {
                left = right + 1;
            }

            // Current window is:
            // [left ... right]
            //
            // Every element in this window is <= limit.
            //
            // Number of valid subarrays ending at 'right':
            // right - left + 1
            count += right - left + 1;
        }

        return count;
    }
}