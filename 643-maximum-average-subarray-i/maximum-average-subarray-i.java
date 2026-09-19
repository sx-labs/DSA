class Solution {
    public double findMaxAverage(int[] nums, int k) {
     int left = 0 ;
     double maxsum = Integer.MIN_VALUE;
     double currsum = 0;
     for(int right = 0 ; right<nums.length ; right++) {
        currsum+= nums[right];

// when it reaches the length  k firsr we calculate the maxsum of that particular length
        if(right-left+1 == k) {
            maxsum = Math.max(maxsum , currsum);
            currsum -= nums[left];
            left++;
        }
     }
     return maxsum/k;
    }
}

/*
One important detail

Use:

Integer.MIN_VALUE

instead of:

0

because the array can contain all negative numbers.

For example:

nums = [-5,-6,-2]
k = 2

The maximum sum is:

-8

If you started with:

maxsum = 0;

you would incorrectly keep 0 */