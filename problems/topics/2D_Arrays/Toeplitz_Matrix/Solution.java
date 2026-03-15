/**
 * 766. Toeplitz Matrix
 * 
 * Approach: Compare with Top-Left Neighbor
 * Time Complexity: O(M * N)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Start from row 1 and col 1, comparing each element to its top-left neighbor
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false; // Found a mismatch on a diagonal
                }
            }
        }
        
        return true; // All diagonals are valid
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[][] matrix1 = {
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {9, 5, 1, 2}
        };
        System.out.println("Test Case 1 Output: " + solution.isToeplitzMatrix(matrix1)); // Expected: true

        // Test Case 2
        int[][] matrix2 = {
            {1, 2},
            {2, 2}
        };
        System.out.println("Test Case 2 Output: " + solution.isToeplitzMatrix(matrix2)); // Expected: false
    }
}
