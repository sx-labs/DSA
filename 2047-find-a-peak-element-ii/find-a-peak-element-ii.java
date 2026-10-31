class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length ;
        int col = mat[0].length;

        int low = 0 ;
        int high = col-1;
        while(low<= high) {
            int mid = low + (high - low)/2;
            int maxRow = 0;
            int maxVal = mat[0][mid];
            //now traverse all the rows after finding the mid
            for(int i = 0 ; i < row ; i++) {
                if(mat[i][mid]> maxVal) {
                    maxVal = mat[i][mid];
                    maxRow = i;
                }
            }
            //to handle specific boundary condtions we use ternary condtion
            int left = (mid == 0) ? -1 : mat[maxRow][mid-1];
            int right = (mid ==col-1) ? -1 : mat[maxRow][mid+1];
            if(mat[maxRow][mid]> left && mat[maxRow][mid]> right) {
                return new int[]{maxRow , mid};
            }
            else if(left>mat[maxRow][mid]) {
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}