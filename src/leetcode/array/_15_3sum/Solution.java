package leetcode.array._15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * <a href="https://leetcode.com/problems/3sum/">...</a>
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        int left, right, sum;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left += 1;
                } else if (sum > 0) {
                    right -= 1;
                } else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복된 값 건너뛰기
                    while (left < right && nums[left] == nums[left + 1])
                        left += 1;
                    while (right > left && nums[right] == nums[right - 1])
                        right -= 1;
                    left += 1;
                    right -= 1;
                }
            }
        }
        return results;
    }
}
