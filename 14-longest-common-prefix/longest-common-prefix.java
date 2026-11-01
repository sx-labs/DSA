class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int min = strs[0].length(); //to acces first char inside a  array of string
        for(int i = 0 ; i<strs.length ; i++) {
            min = Math.min(min , strs[i].length());
        }
        for(int j = 0 ; j<min ; j++) { //j is index number
            char ch = strs[0].charAt(j); //so char should use i since i is string number
            for(int i = 0 ; i<strs.length ; i++) {
                if(strs[i].charAt(j) != ch) { //since i selects the string and j selects that string's character
                    return sb.toString();
                }
            }
               
            sb.append(ch);// don't Append inside the inner loop will append the same character multiple times. Append only after all strings have passed the comparison.
            
        }
        return sb.toString(); //Suppose all characters match until the end of the shortest string. What should you return? You don't need a separate return "" statement because an empty StringBuilder already represents an empty prefix.
    }
}