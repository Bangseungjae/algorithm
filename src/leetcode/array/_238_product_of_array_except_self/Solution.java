package leetcode.array._238_product_of_array_except_self;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= p;
            p *= nums[i];
        }
        return result;
    }
}

/*
1 2 3 4

-- 1 --
1 : 1
1 : 2
2 : 6
6 : 24

6 : 4
8 : 12
12 : 24
24 : 24


 */