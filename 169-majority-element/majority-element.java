
class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;

        // The majority element must occur more than n/2 times
        int occu = n / 2;

        // Store elements whose occurrences we have already counted
        HashSet<Integer> set = new HashSet<>();

        // Select each element as a potential majority element
        for (int i = 0; i < n; i++) {

            // Process an element only if we haven't counted it before
            if (!set.contains(nums[i])) {

                // Count the current occurrence
                int count = 1;

                // Count the remaining occurrences of nums[i]
                for (int j = i + 1; j < n; j++) {

                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }

                // Check whether this element is the majority element
                if (count > occu) {
                    return nums[i];
                }

                // Mark this element as already processed
                set.add(nums[i]);
            }
        }

        // The problem guarantees that a majority element exists
        return -1;
    }
}

/*
import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;
        int occu = n / 2;

        // Store each element and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count the frequency of each element
        for (int i = 0; i < n; i++) {

            if (map.containsKey(nums[i])) {
                // Element already exists: increase its frequency
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                // First occurrence of this element
                map.put(nums[i], 1);
            }
        }

        // Step 2: Find the element whose frequency exceeds n/2
        for (int key : map.keySet()) {

            if (map.get(key) > occu) {
                return key;
            }
        }

        return -1;
    }
}*/