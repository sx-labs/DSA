class Solution {
    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (mid % 2 == 1) { 
                mid--; //Instead we will make even before comparing
            }

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2; //mid +2 cuz we have confirmed that mid and mid+1 forma a pair so we will search from next of mid+1
            } else {
                right = mid; //we do this when answer can be mid also
            }
        }

        return nums[left];
    }
}
