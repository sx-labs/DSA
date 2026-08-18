class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxlen = 0;
        HashMap<Integer , Integer> basket = new HashMap<>();
        for(int right = 0 ; right<fruits.length ; right++) {
            //add current fruit
            basket.put(fruits[right], basket.getOrDefault(fruits[right],0)+1 );
            while(basket.size() >2) {
                // we use getOrDefault cuz get can become null 
                basket.put(fruits[left], basket.getOrDefault(fruits[left],0)-1);
                
            
            //if no fruits of this type is left
            if(basket.get(fruits[left])==0) {
                basket.remove(fruits[left]);
            }
            left++; }
            maxlen = Math.max(maxlen , right-left+1);
        }
        return maxlen;
    }
}