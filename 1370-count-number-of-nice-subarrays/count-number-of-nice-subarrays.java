class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums , k) - atMost(nums , k-1);
    }

    private int atMost(int[] nums, int k) {
        int oddcount = 0;
        int count = 0;
        int left=0;
        for(int right =0 ; right<nums.length ; right++) {
            if(nums[right]%2 != 0) {
                oddcount++;
            }
            while(oddcount>k) {
                if(nums[left]%2 != 0) {
                    oddcount--;
                }
                left++;
            }
            count+= right-left+1;
        }
        return count;
    }

}


/*
class Solution
│
├── public numberOfSubarrays()   ← LeetCode enters here
│
└── private atMost()             ← helper used internally

You could technically make atMost public and the code would still work, but private communicates:

"This is an implementation/helper method, not the main method users are supposed to call."*/