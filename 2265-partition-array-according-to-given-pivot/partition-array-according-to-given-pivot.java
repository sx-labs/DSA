class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int index = 0;
        int[] result = new int[nums.length];
        for(int num : nums) {
            if(num<pivot) {
                result[index++] = num;
            }
        }
        for(int num : nums){
            if(num==pivot) {
                result[index++] = num;
            }
        }
        for(int num : nums) {
            if(num>pivot) {
                result[index++] = num;
            }
        }
        return result;
    
    }
}

/*
public int[] pivotArray(int[] nums, int pivot) { 
//count elemnts less thna or equal to pivot
int less = 0;
int equal = 0;

for(int num: nums) {
if(num <pivot) {
less++;}
}
for(int num: nums) {
if(num == pivot) {
equal++;
}}

int[] ans = new int[nums.length];

//Step 2: Starting position of each section
int lessindex = 0;
int equalindex = less;
int greaterindex = lessindex + equalindex;

for(int num: nums) {
if(num <pivot) {
nums[lessindex]= nums;
lesindex++;
}

for(int num: nums) {
if(num == pivot) {
num[equalindex]= num;
equalindex++;
}
}
for(int num: nums) {
if(num>pivot) {
num[greaterindex] = num;
greaterindex++;
}
return ans;
}
} */

