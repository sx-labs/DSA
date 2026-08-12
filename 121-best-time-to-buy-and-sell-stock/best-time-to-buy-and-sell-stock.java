class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        //You want buyprice to remember the cheapest price seen so far. not initalize again and again inside the for loop 
        int buyprice = prices[0];
        for(int i = 0 ; i<prices.length ; i++) {
            if(buyprice<prices[i]) {
                int profit = prices[i] - buyprice;
                maxprofit = Math.max(maxprofit , profit);
            }
            else {
                buyprice = prices[i];
            }
        }
        return maxprofit;
    }
}