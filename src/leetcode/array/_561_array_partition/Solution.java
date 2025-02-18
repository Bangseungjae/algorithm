package leetcode.array._561_array_partition;

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int sum = 0;

        while (i < nums.length) {
            sum += nums[i + 1];
            i += 2;
        }
        return sum;
    }
}

/*
[6,2,6,5,1,2]
1 2 2 5 6 6
2 5 6
 */