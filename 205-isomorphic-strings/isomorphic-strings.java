class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;
        int[] arrST = new int[256]; //to store ASCII values
        int[] arrTS = new int[256];

        for(int i = 0 ; i<s.length() ; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(arrST[a] != arrTS[b]) return false; //. It's comparing the stored history of those characters.
            
            arrST[a] = i+1; /* i is the current index. i + 1 is the value we store in the array.We use i + 1 because 0 is reserved to mean that the character has never appeared before. */
            arrTS[b] = i+1;
        }

        return true;
    }
}