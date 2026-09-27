class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxsum = nums[0];
        int currmax = nums[0];

        int minsum = nums[0];
        int currmin = nums[0];

        for(int i = 1 ; i<nums.length ; i++) {
            //maximum subarray
            currmax = Math.max(nums[i] ,currmax +nums[i] );
            maxsum = Math.max(currmax , maxsum);

            //minimum subarray
            currmin = Math.min(nums[i] , currmin+ nums[i]);
            minsum = Math.min(currmin , minsum);

        }
        int ans = Math.max(maxsum , Math.abs(minsum));

        return ans;

    }
}