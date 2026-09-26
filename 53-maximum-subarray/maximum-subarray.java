class Solution {
    //Kadanes algo
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int currsum = 0;
        for(int num : nums) {
            currsum += num;
            maxsum = Math.max(maxsum , currsum);

            if(currsum<0) {
                currsum = 0;
            }
        }
        return maxsum;
    }
}