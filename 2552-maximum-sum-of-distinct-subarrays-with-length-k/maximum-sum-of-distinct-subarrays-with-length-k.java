class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        long maxsum = 0;
        long currsum = 0;
        //"Have I already seen this number inside my current window?" That's exactly what a HashSet is useful for.
        Set<Integer> set = new HashSet<>();
        for(int right = 0 ; right<nums.length ; right++) {
            // when set is duplicate or set size is equal to k
            while(set.contains(nums[right]) || set.size()== k) {
                set.remove(nums[left]);
                currsum -= nums[left];
                left++;
            }
            //else just add the nums[right]
            currsum += nums[right];
            set.add(nums[right]);
            // find maxsum only when the size of set reaches k not before that
            if(set.size()== k) {
                maxsum = Math.max(maxsum , currsum);
            }
        }
        return maxsum;
    }
}