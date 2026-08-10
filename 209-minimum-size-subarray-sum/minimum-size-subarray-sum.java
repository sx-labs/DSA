class Solution { //no hashset rquired since duplicates are allowed
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0 ;
        int minlen = Integer.MAX_VALUE;
        int currsum = 0;
        for(int right = 0 ; right<nums.length ; right++) {
            currsum += nums[right];
            while(currsum>= target) { //since this ia continous process we use while not if cuz once the sum reaches the target, we should keep removing from the left as long as the sum is still ≥ target.
                // so to find the minimum length we will now decrease from left side
                minlen = Math.min(minlen , right-left+1);
                currsum -= nums[left];
                left++;
                
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
        
    }
}
/*Note - we write minlen above currsum and not below left++
At some point we have:

[2,3,1,2]
 ↑     ↑
left  right

Sum = 8, so this is a valid window.

Its length is:

right - left + 1
= 3 - 0 + 1
= 4

Now we want to shrink it. */