class Solution {
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length -1;
        while(left<= right) {
            int mid = left + (right - left)/2;
            if(nums[mid]== target) return mid;

            //If left part is sorted
            if(nums[mid]>= nums[left]) {
                //sorted hai check target hai na us part me
                if(target>= nums[left] && target < nums[mid]) {
                    right = mid-1;
                }
                else {
                    left= mid+1;
                }
            }
            //right part is sorted
            else {
                //check first ki kya is sorted part me target hai
                if(target> nums[mid] && target<= nums[right]) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}