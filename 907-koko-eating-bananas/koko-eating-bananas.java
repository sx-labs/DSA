class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        int ans = -1;
        for(int i = 0 ; i<piles.length ; i++) {
            max = Math.max(max , piles[i]);
        }
            while(min<= max) {
            int mid = min + (max - min)/2; //if i choose this speed
            long time = 0 ;
            for(int i = 0 ; i<piles.length ; i++) {
                time += Math.ceil((double)piles[i]/mid); //we use double so that division will give value in decimal and then we can ceil it as int pile = 7;
//int mid = 3; so pile/mid = 2 but it is in real 2.333 so we will round of and it will take 3 banana
                }
                if(time<= h) { 
                    ans = mid;
                    max = mid-1;
                }
                else {
                    min = mid+1;
                }

            }
            return ans;
    }
    /*
    The maximum hours occur when: Every pile contains \(10^9\) bananas.
Speed = 1.
Therefore:$$ time = 10^4 * 10^9 = 10^{13} 
But Java's int maximum is:2^31 = −1≈2.147×10^9

And H is at most 10^9 so mid , min ,max can be in int
    */



class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // range of speed 
        int left = 1 ;
        int right = 0; 
        int ans = 0;
        
         // Find the largest pile
        for(int pile : piles) {
            right = Math.max(right , pile);
        }

        // int ans = right; ( or you can intailize with right since we know larget will ofc be the ans but we need to find the smallest actually)
        while(left<= right) {
            // Current speed we are testing ( mid represents speed here)
            int mid = left + (right - left)/2;

            long hours = calculateTotalHours(piles, mid);
            
            // Check whether Koko can finish within h hours
            if(hours <= h) {
                ans = mid;
                right = mid-1; // search left to find aur minimum speed
            }
            else {
                left = mid+1;
            }
        }
        return ans;
    }


    // Separate function to calculate total hours
    private long calculateTotalHours(int[] piles, int mid) {
        long hours = 0; ////For the LeetCode constraints, the total number of hours can become larger than an int can safely hold in some cases. Use long for hours.

        for (int pile : piles) {
            hours += Math.ceil((double) pile / mid);
        }

        return hours;
    }

}
/* 
So we convert one of the two numbers to double:

(double) pile / mid

Now Java says:

double / int

and automatically converts mid to double too:

7.0 / 3.0 = 2.3333...

Then:

Math.ceil(2.3333...)

gives:

3.0 */
