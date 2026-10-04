class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int minspeed = 1 ; int maxspeed = 10000000;
        int ans = -1;
        while(minspeed <= maxspeed) {
            //here mid stands for the speed (we are taking from binary search)
            int mid = minspeed + (maxspeed - minspeed)/2;
            double time = 0;
            for(int i  = 0 ; i<dist.length ; i++) {
                if(i == dist.length-1) {
                    // Last train: don't round up
                    time += (double) dist[i] / mid;
                }
                else {
                     // Other trains: must depart at integer hour
                    time += (dist[i] + mid - 1) / mid;
                }
            }
            if(time<= hour) {
                 // Speed works, try to find a smaller speed
                ans = mid;
                maxspeed = mid-1;
            }
            else {
                 // Speed is too slow, need a larger speed
                minspeed = mid+1; // otherwise we will find zada speed
            }
        }
        return ans;
    }
}