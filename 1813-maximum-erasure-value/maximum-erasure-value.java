class Solution {
    public int maximumUniqueSubarray(int[] nums) {
    int left = 0 ;
    int maxsum = 0;
    int currsum = 0;
    HashSet<Integer> set = new HashSet<>();
    for(int right = 0 ; right<nums.length ; right++) {
        while(set.contains(nums[right])) {
            set.remove(nums[left]);
            currsum-= nums[left];
            left++;
        }
        set.add(nums[right]);
        currsum+= nums[right];
        maxsum = Math.max(maxsum , currsum);
    }
    return maxsum;
    }
}