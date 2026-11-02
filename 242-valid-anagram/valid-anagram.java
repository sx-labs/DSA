class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        // Frequency array of size 26 for all lowercase English letters ('a' to 'z')
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            // - 'a' shifts the ASCII value to map letters into 0-25 indices 
            // (e.g., 'a' - 'a' = 0, 'b' - 'a' = 1)
            // We increment for characters found in s and decrement for characters in t
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        // Verify if all character frequencies balanced out
        for (int c : count) {
            // If any count is not 0, it means the frequencies don't match 
            // (either s had more or t had more of that specific letter)
            if (c != 0) {
                return false;
            }
        }
        
        return true;
    }
}
/*
We do - '0' when working with digit characters (like '0', '1', '2', ..., '9') to convert them into their actual integer values.
*/