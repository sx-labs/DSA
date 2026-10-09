class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int i : nums) {
            right = Math.max(right ,i);
        }
        int ans = 1;
        while(left<= right) {
            int mid = left + (right - left)/2; //divisor we are checking
            long sum = 0 ;
            for(int i = 0 ; i<nums.length ; i++) {
                sum += Math.ceil((double)nums[i]/mid);
            }
            if(sum <= threshold) {
                /*
                mid is a valid divisor.
                Try to find a smaller one.
                */
                ans = mid;
                right = mid-1;
            }
            else {
                // Divisor is too small, so increase it.
                left = mid+1;
            }
        }
        return ans;
    }
}