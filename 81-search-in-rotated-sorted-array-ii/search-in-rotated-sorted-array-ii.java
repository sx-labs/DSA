class Solution {
    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // 1. Found target
            if (nums[mid] == target) {
                return true;
            }

            // 2. Duplicates make it impossible to identify
            // which half is sorted
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }

            // 3. Left half is sorted
            if (nums[left] <= nums[mid]) {

                // Target lies inside sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } 
                // Target is in right half
                else {
                    left = mid + 1;
                }

            }

            // 4. Right half is sorted
            else {

                // Target lies inside sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } 
                // Target is in left half
                else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}