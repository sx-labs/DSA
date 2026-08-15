class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        // Shrink the window from both ends until exactly k elements remain
        while (right - left + 1 > k) {
            // Compare the absolute distance to x from both ends
            int distLeft = Math.abs(arr[left] - x);
            int distRight = Math.abs(arr[right] - x);

            if (distLeft > distRight) {
                // The left element is farther away, shrink from the left
                 left++;
            } else {
                // The right element is farther away (or distances are tied).
                // On a tie, we prefer the smaller value (left), so we discard the right.
                right--;
            }
        }

        // Collect the final k elements into a List
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}