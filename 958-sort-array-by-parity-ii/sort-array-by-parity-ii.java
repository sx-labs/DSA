class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        int evenindex = 0 ;
        int oddindex = 1;
        for(int i = 0 ; i <nums.length ; i++) {
            if(nums[i]%2== 0) {
                ans[evenindex] = nums[i];
                evenindex+= 2;
            }
            else {
                ans[oddindex] = nums[i];
                oddindex += 2;
            }
        }
        return ans;
    }
}