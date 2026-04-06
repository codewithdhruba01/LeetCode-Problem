# 121. Best Time to Buy and Sell Stock

[LeetCode Problem Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

## Description

You are given an array `prices` where `prices[i]` is the price of a given stock on the $i^{th}$ day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return *the maximum profit you can achieve from this transaction*. If you cannot achieve any profit, return `0`.

## Examples

**Example 1:**
```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

**Example 2:**
```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
```

## Constraints

- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^4`

## Approach: Greedy ($O(N)$)

To maximize profit, we want to buy at the lowest possible price and sell at the highest possible price *after* the purchase day.

### Intuition

1. **Greedy Choice**: As we traverse the prices, we maintain the minimum price encountered so far (`minPrice`).
2. **Profit Calculation**: For each day, we assume we sell at the current price and calculate the potential profit: `currentPrice - minPrice`.
3. **Updating Max Profit**: If this potential profit is greater than our current `maxProfit`, we update it.
4. **Updating Min Price**: If the current price is lower than our `minPrice`, we update `minPrice` for future potential sales.

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the number of days. We perform a single pass through the prices array.
- **Space Complexity:** $O(1)$, as we only use two variables to track the state.

## Code (Java)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                // Found a new minimum price to buy at
                minPrice = price;
            } else {
                // Calculate profit if sold today and update max profit
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        
        return maxProfit;
    }
}
```
