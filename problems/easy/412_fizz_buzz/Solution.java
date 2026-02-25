import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * 
 * Approach: String Concatenation
 * Time Complexity: O(N)
 * Space Complexity: O(1) (excluding result list)
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        // Pre-allocate space for performance
        List<String> result = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            String s = "";

            // Check divisibility by 3
            if (i % 3 == 0) {
                s += "Fizz";
            }
            // Check divisibility by 5
            if (i % 5 == 0) {
                s += "Buzz";
            }

            // If string is still empty, none of the conditions were met
            if (s.isEmpty()) {
                s = String.valueOf(i);
            }

            result.add(s);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: n = 3
        System.out.println("n = 3: " + solution.fizzBuzz(3));
        // Expected: [1, 2, Fizz]

        // Test Case 2: n = 5
        System.out.println("n = 5: " + solution.fizzBuzz(5));
        // Expected: [1, 2, Fizz, 4, Buzz]

        // Test Case 3: n = 15
        System.out.println("n = 15: " + solution.fizzBuzz(15));
        // Expected: [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14,
        // FizzBuzz]
    }
}
