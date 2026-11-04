class Solution {
    public int maxDepth(String s) {
        int depth = 0 ;
        int maxdepth = 0 ;
        for(int i = 0 ; i<s.length() ; i++) {
            if(s.charAt(i) == '(') {
                depth++;
            }
            else if(s.charAt(i) == ')'){ //Since the problem guarantees a valid parentheses string containing digits and operators too, it's safer and clearer to explicitly check for ')'
                depth--;
            }
            maxdepth = Math.max(maxdepth , depth);
        }
        return maxdepth;
    }
}