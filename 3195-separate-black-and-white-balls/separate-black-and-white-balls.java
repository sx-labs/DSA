class Solution {
    public long minimumSteps(String s) {
       long black = 0;
       long swap = 0;
       for(int i = 0 ; i<s.length() ; i++) {
        if(s.charAt(i)== '1') {
            black++;
        }
        else {
            swap += black; //jitne black balls hai 0 ke aage utne baar 0 aage jayega [1,1,0] => [0,1,1]
        }
       }
       return swap;
    }
    
}