class Solution {
    public int findKthPositive(int[] arr, int k) {

        int[] arra = new int[k];
        int num = 1;
        int j = 0;

        while (j < k) { 

            boolean found = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == num) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                arra[j] = num;
                j++;
            }

            num++;
        }

        return arra[k - 1];
    }
}