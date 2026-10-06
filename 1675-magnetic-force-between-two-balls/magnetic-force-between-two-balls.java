class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0 ; i<position.length ; i++) {
           max = Math.max(max , position[i]) ;
           min = Math.min(min , position[i]) ;
        }
        int right = max - min;

        while(left<= right) {
            //mid is assumed minimum force
            int mid = left + (right - left)/2;
            int laspos = position[0];
            int ballsplaced = 1; // we already placed one ball at index 0
            for(int i = 0 ; i<position.length ; i++) {
                //actual distance >= required distance so we can put (because we need the distance to be at least our assumed minimum force.)
                if(position[i] - laspos >= mid) {
                    //but lastPos should store the position value, not the index.
                    laspos = position[i];
                    ballsplaced++;
                }
            }
            /*
            Why not <=?
            Suppose:    m = 3  ballsPlaced = 2
            2 <= 3 is true, but can we actually distribute 3 balls?
            ❌ No.
            */
            if(ballsplaced>=m) {
                ans = mid;
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return ans;
    }
}