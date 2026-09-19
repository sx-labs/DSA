class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        int windowsize = p.length();
        int left = 0;
        int freq[] = new int[26];
        int freq2[] = new int[26];
        for(int i= 0 ; i<windowsize ; i++) {
            freq[p.charAt(i) - 'a']++;
        }
        for(int right = 0 ; right<s.length(); right++) {
            // Add current character to window
            freq2[s.charAt(right)-'a']++;
             // If window becomes bigger than k, remove left character
            if (right - left + 1 > windowsize) {
                freq2[s.charAt(left) - 'a']--;
                left++;
            }
             // Now window size is exactly k (first we maintain the valid window)
            if(right-left+1 == windowsize) {
                if(Arrays.equals(freq , freq2)) {
                    l.add(left);
                }
            }
        }
        return l;
    }
}