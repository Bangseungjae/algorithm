package leetcode.bst._240;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}

// 6ms 49.01% Beats
//class Solution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        for (int i = 0; i < matrix.length; i++) {
//            int left = 0, right = matrix[i].length - 1;
//            while (left < right) {
//                int mid = left + (right - left) / 2;
//                if (matrix[i][mid] == target)
//                    return true;
//                else if (matrix[i][mid] < target)
//                    left = mid + 1;
//                else
//                    right = mid - 1;
//            }
//        }
//        return false;
//    }
//}