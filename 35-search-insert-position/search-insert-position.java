class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0 , right = nums.length -1;
        while(left<= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left= mid+1;
            else right = mid-1;
        }
        return left;
    }
}
/*
o left is exactly where the target should be inserted.

For example:

[1, 3, 5, 6]
target = 2

left = 1
right = 0

        ↓
[1, 3, 5, 6]
    ↑
   left


Insert 2 at index 1, so:

return left; */