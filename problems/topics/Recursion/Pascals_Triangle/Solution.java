import java.util.*;

/**
 * 118. Pascal's Triangle
 * 
 * Approach: Iterative Dynamic Programming (Construction from previous row)
 * Time Complexity: O(numRows^2)
 * Space Complexity: O(numRows^2)
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // Boundary elements are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Internal elements = sum of two elements directly above in the previous row
                    int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(val);
                }
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Test Case 1 (numRows = 5): " + solution.generate(5));
        // Expected: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

        // Test Case 2
        System.out.println("Test Case 2 (numRows = 1): " + solution.generate(1));
        // Expected: [[1]]
    }
}
