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

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int capacity = 0;
        int maxWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            capacity += weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }

        for (int cap = maxWeight; cap <= capacity; cap++) {
            int day = 1;
            int load = 0;

            for (int i = 0; i < weights.length; i++) {
                if (load + weights[i] > cap) {
                    day++;
                    load = weights[i]; //means load it on the next day
                } else {
                    load += weights[i]; //if capacity is not exceeding keep loading it on the same day
                }
            }

            if (day <= days) {
                return cap;
            }
        }

        return capacity;
    }
}
