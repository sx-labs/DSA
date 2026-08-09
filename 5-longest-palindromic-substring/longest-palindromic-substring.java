class Solution {
    public String longestPalindrome(String s) {
       int maxlen = 0 ;
       int start = 0;
       for(int i = 0 ; i<s.length(); i++) {
        //to check for odd palindrome
        int len1 = palindromeexpandversion(s,i,i);
        //to check for even palindrome
        int len2 = palindromeexpandversion(s , i,i+1);
        int len = Math.max(len1 , len2);
        if(len>maxlen) {
            maxlen = len;
            start = i - (len-1)/2;// center - expansion possible from centre //1 here means centre len -1
        }
        
       }
       return s.substring(start , start+maxlen);
    }
   
    
    public int palindromeexpandversion(String s , int l , int r) {
        // condition to compare included only becuz stop the loop when characters don't match
        while(l>= 0 && r<s.length() && s.charAt(l)== s.charAt(r)) {
                l--;
                r++;
            }
        
        return r-l-1; //(r-1) - (l+1) - 1 = r-l-1
    }
    
}

/* 
 public String longestPalindrome(String s) {
       int maxlen = 0;
       int start = 0 ;
       for(int i =0 ; i< s.length();i++) {
        for(int j = i ; j<s.length(); j++) {
            if(ispalindrome(s,i,j)) {
                if(j-i+1 > maxlen) {
                    maxlen = j-i+1;
                    start = i;
                }
                
            }
            
        }
       }
       return s.substring(start , start+maxlen);
    }
    public boolean ispalindrome(String a , int i , int j) {
        while(i<j) {
            if(a.charAt(i)!= a.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    } */