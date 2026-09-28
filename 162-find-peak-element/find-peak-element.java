class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0 , right = nums.length -1;
        /*
        What if: left = right = nums.length - 1
        Then:
        mid = nums.length - 1
        mid + 1 = nums.length
        But nums[nums.length] doesn't exist → ArrayIndexOutOfBoundsException.
        */
        while(left< right) {
            int mid = left + (right - left)/2;

            if(nums[mid]< nums[mid+1]) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        /* 
        When the loop finishes: left == right
        That remaining index is a peak.
        */
        return left;
    }
}