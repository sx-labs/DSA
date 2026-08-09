class Solution {
    public int countSubstrings(String s) {
        int count = 0 ;
        for(int i = 0 ; i<s.length(); i++) {
            // for odd palindromes or even 
            count += palindromeexpand(s , i , i);
            count+= palindromeexpand(s , i , i+1);
        }
        return count;
    }
    public int palindromeexpand(String s , int l , int r) {
        int count = 0;
        while(l>= 0 && r<s.length() && s.charAt(l)== s.charAt(r)) {
                count++;
                l--;
                r++;
               
        }
        return count;
    }
}

/*
public int countSubstrings(String s) {
        int count =0 ;
       for(int i = 0 ; i<s.length() ; i++) {
        for(int j = i ; j<s.length(); j++) {
            if(ispalindrome(s,i,j)) {
                count++;
            }
        }
       }
       return count;
    }
    
    public boolean ispalindrome(String s , int i , int j) {
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
} */