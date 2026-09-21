class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
         
         // Before the array starts:
        // prefix sum = 0 at index -1
        map.put(0,-1);

        
        int sum = 0;

        for(int i =0 ; i<nums.length ; i++) {

            //build prefix sum
            sum += nums[i];
            
            //hume sirf remainder se mtlv h is ques me
            int rem  = sum%k; //we need rem of the sum not number only
            
            //have we seen this remainder before
            if(map.containsKey(rem)) {
                
                //agr h voh remainder toh uski length calculate kro
                int length = i - map.get(rem);
                
                //check krlo voh length at least 2 h toh return krdo true cuz we want that
                if(length>= 2) {
                    return true;
                }
            } //2 if - else


                //nahi toh us rem ko daldo map me
                else {
                    map.put(rem,i);
                }
            }
    
        return false;
    }
}