class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        //If the number of flowers we need is greater than the number of flowers we have, it's impossible.
        if ((long) m * k > bloomDay.length) {
        return -1;
        }

        int minday = bloomDay[0] ; //n >= 1, bloomDay[0] definitely exists, which makes the first style convenient.
        int maxday = bloomDay[0] ;
        int ans = -1; //If it is impossible to make m bouquets, return -1. given in que
        for(int i : bloomDay) {
            minday = Math.min(minday ,i);
            maxday = Math.max(maxday , i);
        }
        while(minday<= maxday) {
            int consecutive = 0 ; 
            int bouquet = 0 ;
            //mid means: "Suppose I wait until this day. Can I make m bouquets?"
            int mid = minday + (maxday - minday)/2;
            for(int i = 0 ; i<bloomDay.length ; i++) {
                if(bloomDay[i]<= mid) {
                    consecutive++;
                    if(consecutive == k) {
                        bouquet++;
                        consecutive = 0;
                    }
                }
                else {
                    // Unbloomed flower breaks the adjacent group
                    consecutive = 0;
                }
             }
             //Did we manage to make enough bouquets?
             if(bouquet>= m) {
                // mid is possible.
                // Try to find an earlier possible day.
                ans = mid;
                maxday = mid-1;
             }
             else {
                 // mid is not possible.
                // Need more days.
                minday = mid+1;
             }
        }
        return ans;
    }
}

Note - /* 
    The loop checks indexes in order: 0 → 1 → 2 → 3 → 4.

Therefore, when consecutive increases, it means the current flower and the immediately preceding flowers in the current uninterrupted run have all bloomed.

If an unbloomed flower appears, the else resets the count, so flowers separated by it cannot accidentally be counted together
    */
