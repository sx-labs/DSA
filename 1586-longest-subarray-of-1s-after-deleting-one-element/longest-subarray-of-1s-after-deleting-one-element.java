class Solution {
    public int longestSubarray(int[] nums) {
        int maxlen = 0 ;
        int left = 0;
        int zerocount = 0 ;
        for(int right = 0 ; right<nums.length ; right++) {

             // Add right element to window
            if (nums[right] == 0) {
                zerocount++;
            }
              // Shrink until window has at most one zero
            while(zerocount>1) {
                if(nums[left] == 0 ) {
                    zerocount--;
                }
                left++;

            }
            maxlen = Math.max(maxlen , right-left+1);
        }
        return maxlen - 1;
        /*
        Our window is allowed to contain one zero, but the problem says we must delete exactly one element.

        Example: [1, 1, 0, 1]
        Window length = 4
        Delete 0 → 3 ones.
        So: answer = window length - 1
        */
    }
}