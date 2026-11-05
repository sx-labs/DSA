class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums , k) - atmost(nums , k-1);
    }

    public int atmost(int[] nums , int k) {
        int left = 0;
        int count = 0;
        int distinct =0;

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int right = 0 ;right<nums.length ; right++) {
            map.put(nums[right] , map.getOrDefault(nums[right] , 0 ) + 1); {
                //if it's value = 1 only then we will inc dis
                if(map.get(nums[right]) == 1) distinct++;
            }

            while(distinct>k) {
                map.put(nums[left] , map.get(nums[left]) - 1);

                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                    distinct--;
                }
                left++;
            }
            count += right - left +1;
        }
        return count;
    }
}

/* Bruteforce */
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int goodarray = 0;
        for(int i = 0 ; i<nums.length ; i++) {
              HashSet<Integer> set = new HashSet<>(); /*This means the same set is being reused for every starting index. But when i changes, we're starting a completely new group of subarrays. So the set should be reset for every new starting index. 
              (Should we clear the HashSet when j moves from 2 to 3? Or should we retain [1, 2] and process the new element?) */
            for(int j = i ; j<nums.length; j++) {
               if(!set.contains(nums[j])) {
                    set.add(nums[j]);
               }
                if(set.size() == k) {
                    goodarray++;
                }
            }
        }
        return goodarray;
    }
}
