class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count  =0;
        int maxconsecutives = 0;
        for(int i = 0 ; i<nums.length ; i++) {
            if(nums[i] == 1) {
                count++;
                maxconsecutives = Math.max(maxconsecutives , count);
            }
            else {
                //mtlv we restart once we find a 0 to find max consecutives
                count = 0 ;
            }

        }
        return maxconsecutives;
    }
}