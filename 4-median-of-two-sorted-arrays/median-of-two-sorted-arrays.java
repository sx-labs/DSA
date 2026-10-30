class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int n = n1 + n2;

        int ind1 = n/2 -1;
        int ind2 = n/2;

        int indlen1 = -1;
        int indlen2 = -1;

        int i = 0;
        int j = 0;

        int cnt = 0;

        // Process both arrays together
        while(i<n1 && j<n2) {
            if(nums1[i] < nums2[j]) {
            if(cnt == ind1) indlen1 = nums1[i];
            if(cnt == ind2) indlen2 = nums1[i];
            cnt++;
            i++;
        }
        else {
            if(cnt == ind1) indlen1 = nums2[j];
            if(cnt == ind2) indlen2 = nums2[j];
            cnt++;
            j++;
        }
    }
    // Process remaining elements of first array
    while(i<nums1.length) {
        if(cnt == ind1) indlen1 = nums1[i];
        if(cnt == ind2) indlen2 = nums1[i];
        cnt++;
        i++;
    }
    // Process remaining elements of second array
    while(j<nums2.length) {
        if(cnt == ind1) indlen1 = nums2[j];
        if(cnt == ind2) indlen2 = nums2[j];
        cnt++;
        j++;
    }
    // Calculate median
    if(n%2 == 1) {
        return indlen2;
    }
    return (indlen1 + (double) indlen2) / 2;
}
}