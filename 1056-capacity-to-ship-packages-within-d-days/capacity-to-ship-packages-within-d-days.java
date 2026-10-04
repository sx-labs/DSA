class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int mincapacity = 0; int maxcapacity = 0 ;
        for(int i : weights) {
            mincapacity = Math.max(mincapacity , i);
            maxcapacity += i;
        }
            int ans = maxcapacity;
        while(mincapacity<= maxcapacity) {
            //note - we have to choose capacity from the weights and this mid is assumption of one of the capacity
            int mid = mincapacity + (maxcapacity - mincapacity)/2;

            //on day 1 when we start loading packages
            int day = 1;
            int sum = 0 ;
            for(int weight : weights) {
                if(sum + weight > mid) {
                    day++;
                    sum = 0;
                }
                sum += weight;
            }
            if(day <= days) {
                ans = mid;
                maxcapacity = mid-1;
            }
            else {
                mincapacity = mid+1; //we will find more capacity
            }
        }
        return ans;
    }
}