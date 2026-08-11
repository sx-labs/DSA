class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int left = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        //fixed size window approach use hoga so uske liye we will add below
        //count the frequency in s1 string
        for(int i = 0 ; i<s1.length() ; i++) {
            freq1[s1.charAt(i)-'a']++;
        }
        //count frequency in s2 string
        for(int right = 0 ; right<s2.length() ; right++) {
            freq2[s2.charAt(right)- 'a']++;

            //window size maintain here
            // If window becomes bigger than s1,
            // remove the character from the left
            if(right-left+1 >s1.length()) {
                //jese set me se remove krte the idhe we are storing in freq array so isme se remove krenge
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            // If window has exactly same size as s1,
            // compare frequencies
            if(right-left+1 == s1.length()) {
                if(Arrays.equals(freq1 , freq2)){
                return true;
            }
            }
            
        }
        return false;
    }
}