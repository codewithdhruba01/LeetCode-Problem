/**
 * 240. Search a 2D Matrix II
 * 
 * Approach: Top-Right Pointer Traversal
 * Time Complexity: O(M + N) -> M rows, N columns
 * Space Complexity: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner
        int r = 0;
        int c = cols - 1;

        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true; // Target found
            } else if (matrix[r][c] > target) {
                // Current element is too large, move left to find smaller elements
                c--; 
            } else {
                // Current element is too small, move down to find larger elements
                r++; 
            }
        }

        return false; // Target not found within boundaries
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[][] matrix1 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target1 = 5;
        System.out.println("Test Case 1 Output: " + solution.searchMatrix(matrix1, target1)); // Expected: true

        // Test Case 2
        int[][] matrix2 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target2 = 20;
        System.out.println("Test Case 2 Output: " + solution.searchMatrix(matrix2, target2)); // Expected: false
    }
}
