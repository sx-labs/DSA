class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left<right) {
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[right]) {
                /* Since 7 > 2, the rotation break—and therefore the minimum—must be to the right of mid.*/
                right = mid;
            }
            else {
               /* Since 7 > 2, the rotation break—and therefore the minimum—must be to the right of mid. */
                left = mid+1;
            }
        }
        return nums[left];
    }
}