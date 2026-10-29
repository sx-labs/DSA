class Solution {
    public int splitArray(int[] nums, int k) {
        int min = 0;
        int max = 0;
        int ans= 0 ;
        for(int i = 0 ; i<nums.length ; i++) {
            max += nums[i];
            min = Math.max(min , nums[i]);
        }
        while(min <= max) {
            int mid = min + (max - min)/2;
            int sum = 0;
            int subarray = 1;
            for(int i = 0 ; i<nums.length ; i++) {
                if(sum + nums[i] > mid) {
                    subarray++;
                    sum = nums[i];
                }
                else {
                    sum += nums[i];
                }
            }
            if(subarray <= k) {
                ans = mid;
                max = mid-1;
            }
            else {
                min = mid+1;
            }
        }
        return ans;
    }
}