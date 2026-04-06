# Revision Notes: Best Time to Buy and Sell Stock

## Core Concept
- **The Observation**: You only need to know the minimum price that occurred *before* the current day to find the max profit if you sold today.
- **Greedy Strategy**: Keep track of the lowest price seen so far and compare it with the current price to find the maximum possible gain.

## Implementation Steps
1. Initialize `minPrice` as `MAX_VALUE`.
2. Initialize `maxProfit` as `0`.
3. Iterate through `prices`:
   - If `price < minPrice`, update `minPrice`.
   - Else, update `maxProfit = max(maxProfit, current_price - minPrice)`.

## complexity
- **Time**: $O(N)$ - Single pass through the array.
- **Space**: $O(1)$ - Only two extra variables (`minPrice`, `maxProfit`).

## Why is it Greedy?
- At each step, we make the locally optimal choice:
  1. "Is this the cheapest I've seen the stock?" (Update `minPrice`)
  2. "If I sell now, is my profit higher than any previous scenario?" (Update `maxProfit`)
- By the end of the loop, these local "best" choices lead to the global maximum profit.

## Common Pitfalls
- **Incorrect Order**: Forgetting that you must buy before you sell.
- **Single Variable**: Attempting to track only the global max/min without context of time (index).
- **Initial Profit**: Returning a negative profit instead of 0 if the stock only goes down.
