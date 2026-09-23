class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count =0 ;
        int sum =0 ;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0 ; i<nums.length ; i++) {

            sum += nums[i];

            int required = sum - goal;

            if(map.containsKey(required)) {
                count += map.get(required);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}