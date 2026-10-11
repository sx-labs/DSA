class Solution {
    public boolean isPalindrome(int x) {
        int orig = x;
        long rev= 0;
        if(x<0) {
            return false;
        }
        while(x> 0) {
            int digit = x%10;
            rev = rev*10 +digit;
            x = x/10;
        }
        if(rev == orig) {
            return true;
        }
        else {
           return false;
        }
    }
}
/*
Not quite, bro ❤️ Let's dry-run x = 0.

orig = 0
rev = 0
Your loop condition is x > 0.

Question: Is 0 > 0 true or false?

If it's false, the loop won't execute, so rev will remain 0.

Then your condition rev == orig compares 0 == 0.

So your code will return true, which is correct because 0 is a palindrome! 🎯 */