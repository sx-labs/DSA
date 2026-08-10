class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;
        int maxlen = 0;
        HashSet<Character> set = new HashSet<>();
        for(int right = 0 ; right<s.length() ; right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlen = Math.max(maxlen , right-left+1);
        }
        return maxlen;
    }
}
/*
4. But there is an important difference

This is where you should distinguish the two problems.

Maximum Subarray Sum

The window must have:

EXACTLY k elements

So:

window size = k

And it must have:

all distinct

We update the answer when:

set.size() == k
Longest Substring Without Repeating

There is no fixed k.

We simply want the largest valid window.

So:

window can be:
"a"
"ab"
"abc"
"bc"
"bca"
...

We update:

maxLength = Math.max(maxLength, right - left + 1);

whenever the window is valid. */