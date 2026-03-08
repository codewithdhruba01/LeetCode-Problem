import java.util.*;

/**
 * 54. Spiral Matrix
 * 
 * Approach: Boundary Shrinking (Four Pointers)
 * Time Complexity: O(M * N)
 * Space Complexity: O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right across top boundary
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom across right boundary
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left across bottom boundary
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top across left boundary
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: 3x3 square matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Test Case 1 Output: " + solution.spiralOrder(matrix1));
        // Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Test Case 2: 3x4 rectangular matrix
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println("Test Case 2 Output: " + solution.spiralOrder(matrix2));
        // Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
