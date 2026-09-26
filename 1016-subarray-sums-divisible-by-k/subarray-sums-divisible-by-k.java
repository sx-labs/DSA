class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i = 0 ; i<nums.length ; i++) {
            sum+= nums[i];
             int remainder = ((sum % k) + k) % k;
            if(map.containsKey(remainder)) {
                count+= map.get(remainder);
            }
            /*
            If you need an index:
            prefix/remainder → index
            Example:
            map.put(rem, i);
            If you need a count:
            prefix/remainder → frequency
            Example:
            map.put(rem, map.getOrDefault(rem, 0) + 1);
            */
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}