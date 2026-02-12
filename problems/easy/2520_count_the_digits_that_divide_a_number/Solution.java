class Solution {
    public int countDigits(int num) {
        int original = num;
        int count = 0;

        while (num > 0) {
            int digit = num % 10;
            if (original % digit == 0) {
                count++;
            }
            num = num / 10;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Test Case 1: " + (solution.countDigits(7) == 1 ? "Passed" : "Failed")); // Expected: 1

        // Test Case 2
        System.out.println("Test Case 2: " + (solution.countDigits(121) == 2 ? "Passed" : "Failed")); // Expected: 2

        // Test Case 3
        System.out.println("Test Case 3: " + (solution.countDigits(1248) == 4 ? "Passed" : "Failed")); // Expected: 4
    }
}
