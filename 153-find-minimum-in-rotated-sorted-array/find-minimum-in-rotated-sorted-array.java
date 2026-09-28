class Solution {
    public int findMin(int[] nums) {
        int left = 0 , right = nums.length -1;
        while(left < right) { //Time limit exceed if left<= right
            int mid = left + (right - left)/2 ;
            if(nums[mid] > nums[right]) {
                left = mid+1;
            }
            else {
                //when nums[mid] <= nums[right]
                right = mid;
            }
        }
        /* 
        And because you never throw away the possible minimum, eventually there is only one possible position left: left == right
        That one position must contain the minimum.
        */
        return nums[left];
    }
}