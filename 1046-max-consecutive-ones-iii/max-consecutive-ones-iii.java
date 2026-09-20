class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0 ;
        int maxlen = 0 ;
        int count = 0 ;
        for(int right = 0 ; right<nums.length ; right++) {
            if(nums[right] == 0) {
                count++;
            }
            while(count>k) {
                if(nums[left] == 0) {
                    count--;
                }
                //SO WE CANNOT WRITE LEFT++ IN IF BLOCK
                //You are increasing left only when nums[left] == 0.
                //But left must move for every element, whether it is 0 or 1. Otherwise, if nums[left] is 1, nothing happens:
                 left++;
            }
            maxlen = Math.max(maxlen , right-left+1);
        }
        return maxlen;
    }
}