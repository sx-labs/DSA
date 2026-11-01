class Solution {
    public String largestOddNumber(String num) {
       for(int i = num.length()-1 ; i>=0 ; i--) {
            int c = num.charAt(i) - '0';//to convert a char into integer
            if(c%2 != 0) {
                return num.substring(0,i+1); //since in substring function second index is not inclusive so i+1
            }
       }
       return "";
    }
}
