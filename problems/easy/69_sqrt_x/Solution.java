package problems.easy._69_sqrt_x;

class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == x / mid) {
                return mid;
            }

            if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Test Case 1: " + (solution.mySqrt(4) == 2 ? "Passed" : "Failed")); // Expected: 2

        // Test Case 2
        System.out.println("Test Case 2: " + (solution.mySqrt(8) == 2 ? "Passed" : "Failed")); // Expected: 2

        // Test Case 3 (Large number)
        System.out.println("Test Case 3: " + (solution.mySqrt(2147395599) == 46339 ? "Passed" : "Failed")); // Expected:
                                                                                                            // 46339
    }
}
