class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        int[] freq = new int[26];
        for(int right = 0 ; right<s.length() ; right++) {
            freq[s.charAt(right) - 'A']++; // capital A since it has capital letters
            //But freq is an array, not a number. You need the frequency of the character you just added:
            maxFreq = Math.max(maxFreq , freq[s.charAt(right) - 'A']);

            //3. You need while, not if cuz window may need to shrink multiple times
            while(right-left+1 - maxFreq>k) { //And note replacements while loop me he calculate kro
                //But when shrinking, we remove the character at left, not right. (freq[s.charAt(right)]--; not this)
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            //4. Don't check replacements == k ,A window is valid whenever: replacements <= k Not only when it equals k.
                maxLen = Math.max(maxLen , right-left+1);
            
        }
        return maxLen;
    }
}