class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int low = 0 ;
        int mid = 0 ;
        int end = nums.length-1;
        while(mid<= end) {
            if(nums[mid] %2 == 0) {
                swap(nums , low , mid);
                low++;
                mid++;
            }
            else {
                swap(nums , mid , end);
                end--;
                // we can't do this since that element is not processed yet
                //mid++;
            }
        }
        return nums;
    }
    public void swap(int[] arr , int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}