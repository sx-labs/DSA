class Solution {
    public boolean check(int[] nums) {
        int occurence = 0;
        for(int i = 0 ; i<nums.length-1 ; i++ ) {
            if(nums[i]>nums[i+1]) {
                occurence++;
            }
        }
        if(nums[nums.length-1]> nums[0]) {
                occurence++;
            }
        if(occurence>1) {
            return false;
        }
        else {
            return true;
        }
    }
}

/*
A valid sorted-and-rotated array can have at most one occurrence where an element is greater than the next element, including the comparison between the last and first elements.
*/