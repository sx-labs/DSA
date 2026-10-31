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

//By binary search
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Step 1: Identify the smaller and larger arrays.
        // We perform binary search only on the smaller array
        // to minimize the search space.
        //
        // We still partition BOTH arrays, but we only decide
        // the partition of the smaller array using binary search.
        // The partition of the larger array is calculated automatically.

        int[] smaller = nums1.length > nums2.length ? nums2 : nums1;
        int[] larger = nums1.length > nums2.length ? nums1 : nums2;

        int totalLength = nums1.length + nums2.length;

        // Step 2: Find how many elements should be present
        // in the left half.
        //
        // If totalLength is odd, left half gets one extra element.
        // If totalLength is even, both halves get equal elements.
        int leftSize = (totalLength + 1) / 2;

        // Step 3: Binary search on the smaller array.
        //
        // We are searching for HOW MANY elements to take
        // from the smaller array, not searching for an element value.
        //
        // We can take anywhere from 0 elements to all elements.
        int low = 0;
        int high = smaller.length;

        while (low <= high) {

            // Number of elements taken from the smaller array.
            int partitionX = low + (high - low) / 2;

            // Number of elements taken from the larger array.
            //
            // Why this formula?
            // partitionX + partitionY must equal leftSize.
            //
            // Once partitionX is decided, partitionY is automatically
            // calculated. We don't need another binary search.
            //
            // We use leftSize, NOT totalLength, because we are
            // calculating the number of elements in the LEFT HALF.
            int partitionY = leftSize - partitionX;

            // Step 4: Find the four boundary elements.
            //
            // l1 = last element of smaller array's left half.
            // r1 = first element of smaller array's right half.
            //
            // l2 = last element of larger array's left half.
            // r2 = first element of larger array's right half.

            // If partitionX == 0, no element is taken from smaller's
            // left half, so use MIN_VALUE as a boundary.
            int l1 = partitionX == 0
                    ? Integer.MIN_VALUE
                    : smaller[partitionX - 1];

            // If partitionX == smaller.length, no element remains
            // on the right side, so use MAX_VALUE.
            int r1 = partitionX == smaller.length
                    ? Integer.MAX_VALUE
                    : smaller[partitionX];

            int l2 = partitionY == 0
                    ? Integer.MIN_VALUE
                    : larger[partitionY - 1];

            int r2 = partitionY == larger.length
                    ? Integer.MAX_VALUE
                    : larger[partitionY];

            // Step 5: Check whether our partition is valid.
            //
            // Every element on the LEFT must be <= every element
            // on the RIGHT.
            //
            // We don't compare every element because both arrays
            // are already sorted. We only need to compare boundaries.
            //
            // l1 <= r2 checks smaller's left against larger's right.
            // l2 <= r1 checks larger's left against smaller's right.
            //
            // BOTH conditions are necessary because elements from
            // either array could be incorrectly placed.

            if (l1 <= r2 && l2 <= r1) {

                // We have found the correct partition!

                // CASE 1: Total number of elements is EVEN.
                //
                // The median is the average of:
                // Largest element in the left half = max(l1, l2)
                // Smallest element in the right half = min(r1, r2)

                if (totalLength % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }

                // CASE 2: Total number of elements is ODD.
                //
                // The left half contains one extra element.
                // Therefore, the median is the largest element
                // in the left half.
                //
                // We take MAX because the left half contains
                // elements from both arrays.
                else {
                    return Math.max(l1, l2);
                }
            }

            // Step 6: If partition is invalid, adjust binary search.

            // Too many elements taken from the smaller array.
            // Move its partition towards the LEFT.
            else if (l1 > r2) {
                high = partitionX - 1;
            }

            // Too few elements taken from the smaller array.
            // We need more elements from smaller and fewer from larger.
            else {
                low = partitionX + 1;
            }
        }

        return 0.0;
    }
}
