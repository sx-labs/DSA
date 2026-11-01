class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<s.length() ; i++) {
            char a = s.charAt(i);
           if(a == '(') {
                if(count!=0) sb.append(a);
                count++;
            }
            else {
                count--;
                if(count!=0) sb.append(a);
                /*if(count == 0) continue => this is uneccessary condtion cuz if(count>0) is false so it will move to next iteration na */
            }
        }
           return sb.toString(); 
        }
}