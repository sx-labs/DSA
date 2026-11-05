// We need to calculate beauty for every substring, not just once.
/* Inside the outer loop.But you're trying to access count outside both loops.
That won't work because count is only accessible within the block where you declared it. */
/*
Remember this rule
Variable	- Responsibility	                Where to initialize
beauty	-     Total beauty of all substrings	Before both loops
count	- Frequencies for one starting index	    Inside outer loop
maxfreq	 - Maximum frequency of one substring	   Inside inner loop
minfreq-	Minimum frequency of one substring	     Inside inner loop
*/
class Solution {
    public int beautySum(String s) {
        int beauty = 0;
        for(int i = 0 ; i<s.length() ; i++) {
            int[] count = new int[26];
            for(int j = i ; j<s.length() ; j++) {
                char c = s.charAt(j);
                int n = c - 'a';
                count[n]++;
                int maxfreq = 0;
                int minfreq = Integer.MAX_VALUE;
                int difference = 0;

                for(int k = 0 ; k<count.length ; k++) {
                if(count[k] == 0) continue; //What happens when count[i] is 0 , We must ignore characters that don't appear in the current substring.
                maxfreq = Math.max(maxfreq , count[k]);
                minfreq = Math.min(minfreq , count[k]);
                }
                difference = maxfreq - minfreq;
                beauty += difference;
            }
            
        }
        
        return beauty;
    }
}
/*
1. What happens inside the outer loop?
When i = 0, we generate:
Substring	Frequency of a	Frequency of b
"a"	                   1	0
"aa"	               2	0
"aab"                  2	1

Notice that each substring has different maximum and minimum frequencies.

Therefore, maxfreq and minfreq must be reset for every new value of j. */

/*
Imagine the string is "abc"
We have two decisions:
- i decides where we START reading.
- j decides how far we EXTEND our reading.

Situation 1: i = 0
We start at the first character.

First substring: "a"
a
Frequency: a = 1

Second substring: "ab"
ab
Frequency: a = 1, b = 1

Third substring: "abc"
abc
Frequency: a = 1, b = 1, c = 1

Notice: When we move from "a" to "ab", we don't start counting from zero again.
We already counted a. We just add b.

That's why count is outside the inner loop.
Situation 2: i changes to 1
Now we start a completely new group.

Our substrings are:
"b"
"bc"


We must start counting again because we are no longer starting at a.

That's why count is inside the outer loop. */