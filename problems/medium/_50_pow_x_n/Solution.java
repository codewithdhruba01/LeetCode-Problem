package problems.medium._50_pow_x_n;

class Solution {
    public double myPow(double x, int n) {
        long power = n;
        double result = 1.0;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        while (power > 0) {
            if ((power & 1) == 1) { // If power is odd
                result *= x;
            }
            x *= x;
            power >>= 1; // Divide power by 2
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
                "Test Case 1: " + (Math.abs(solution.myPow(2.00000, 10) - 1024.00000) < 1e-5 ? "Passed" : "Failed")); // Expected:
                                                                                                                      // 1024.0

        // Test Case 2
        System.out.println(
                "Test Case 2: " + (Math.abs(solution.myPow(2.10000, 3) - 9.26100) < 1e-5 ? "Passed" : "Failed")); // Expected:
                                                                                                                  // 9.261

        // Test Case 3
        System.out.println(
                "Test Case 3: " + (Math.abs(solution.myPow(2.00000, -2) - 0.25000) < 1e-5 ? "Passed" : "Failed")); // Expected:
                                                                                                                   // 0.25
    }
}
