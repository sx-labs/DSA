class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        String[] words = s.split(" ");
        int i = 0 ;
        int j = words.length-1;
        while(i<j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
    return String.join(" " , words);
    }
}
/*
After reversing the array, you have something like: words = ["world", "hello"];
But the method must return a single string: "world hello"
So you need to join the array elements into one string, separated by spaces. */