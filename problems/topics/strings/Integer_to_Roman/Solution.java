package problems.topics.strings.Integer_to_Roman;

class Solution {
    public String intToRoman(int num) {
        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] symbols = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Test Case 1: " + (solution.intToRoman(3749).equals("MMMDCCXLIX") ? "Passed" : "Failed")); // Expected:
                                                                                                                      // "MMMDCCXLIX"

        // Test Case 2
        System.out.println("Test Case 2: " + (solution.intToRoman(58).equals("LVIII") ? "Passed" : "Failed")); // Expected:
                                                                                                               // "LVIII"

        // Test Case 3
        System.out.println("Test Case 3: " + (solution.intToRoman(1994).equals("MCMXCIV") ? "Passed" : "Failed")); // Expected:
                                                                                                                   // "MCMXCIV"
    }
}
