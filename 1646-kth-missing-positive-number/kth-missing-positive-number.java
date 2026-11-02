class Solution {
    public int findKthPositive(int[] arr, int k) {

        int low = 0 ;
        int high = arr.length-1;
        while(low<= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] - (mid+1) < k ) {
                    low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low + k;
    }
}

class Solution {
    public int findKthPositive(int[] arr, int k) {

        int low = 0;
        int high = arr.length;//You're searching for an index, not a missing number.
        //So your search space should represent array indices
        while(low<high) {//You're already using mid to access the array. You don't need another loop to check every index. Binary search checks one index at a time.
            int mid = low + (high - low)/2; //i'll suppose that these are my missing no
                if(arr[mid] - (mid+1) < k) {
                    low = mid+1;
                }
                else {
                    high = mid;//if i am using half-interval then condition for high si this
                }
            
        }
        return k+low;
    }
}
