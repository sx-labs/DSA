class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0 ;
        int count = 0;
        int product = 1;
        for(int right = 0 ; right<nums.length ; right++) {
            if(k<= 1) {
                return 0;
            }
            product*= nums[right];
            //Instead, the shrinking happens when product is too large: (cuz product<k toh is valid na we will keep increase till that)
            while(product>=k) {
                product/= nums[left];
                left++;
            }
            count += right-left+1;
            //cuz jitni length hogi utni valid subarrays hogi eg [0,2,3,6] => [0,2], [0,2,3] , [0,2,3,6] 
        }
        return count;
    }
}
/*
2. Your while condition is reversed

You wrote:

while(product < k)

But when:

product < k

the window is already valid.

We don't want to shrink a valid window.

We want to shrink when it becomes invalid:

product >= k

Therefore:

while(product >= k)

Inside it, we remove from the left:

product /= nums[left];
left++; */

/* 
when (k<=1) line
If:

k = 1

then even the smallest possible product is 1.

But:

1 < 1   ❌

So no subarray can ever be valid.

Same for:

k = 0

or any negative k.

Example
nums = [1,2,3]
k = 1

Possible products:

[1]     → 1
[2]     → 2
[3]     → 3
[1,2]   → 2
...

None are < 1.

So answer:

0 */