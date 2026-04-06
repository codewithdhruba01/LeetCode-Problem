/**
 * 121. Best Time to Buy and Sell Stock
 * 
 * Approach: Greedy (Track minimum price so far)
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        // Initialize minPrice to a very large value
        int minPrice = Integer.MAX_VALUE;
        // Initialize maxProfit to 0
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                // Update the minimum price encountered so far
                minPrice = price;
            } else {
                // Calculate profit if we sell at the current price
                // and update maxProfit if it's the best one yet
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: [7,1,5,3,6,4]
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1 Output: " + solution.maxProfit(prices1)); 
        // Expected: 5

        // Test Case 2: [7,6,4,3,1]
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test Case 2 Output: " + solution.maxProfit(prices2)); 
        // Expected: 0
    }
}
