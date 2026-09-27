class Solution {
    public int mySqrt(int x) {
        int left = 0 , right = x;
        /* Let's see with x = 8
        We have: left = 3 ,right = 3
There is exactly one number left to check: 3. */
        while(left<= right) {
            if(x<2)  return x;
            int mid = left+ (right-left)/2;
        /* Make one operand long before multiplication:
           long square = (long) mid * mid;
           Now Java does: long × int → long and there is no integer overflow. */
            long square = (long) mid*mid;
            if(square == x) return (int)mid;
            else if(square > x) right = mid-1;
            else left = mid+1;
        }
        /* 
        Because left has crossed into the invalid side.
        At the end:
        right = last valid answer
        left  = first invalid answer
        So for floor square root, right is the answer.
        */
        return right;
    }
}

/* 
Even though square is long, Java calculates:

mid * mid

as an int first, because mid is an int.

Only after that does Java put the result into long.

For large values, mid * mid overflows the int. */