# 152. Maximum Product Subarray

[LeetCode Problem Link](https://leetcode.com/problems/maximum-product-subarray/)

## Description

Given an integer array `nums`, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a **32-bit** integer.

## Examples

**Example 1:**
```
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
```

**Example 2:**
```
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
```

## Constraints

- `1 <= nums.length <= 2 * 10^4`
- `-10 <= nums[i] <= 10`
- The product of any subarray of `nums` is guaranteed to fit in a **32-bit** integer.

## Approach: Dynamic Programming ($O(N)$)

While calculating the maximum product subarray, we must account for negative numbers. A very small negative number multiplied by another negative number can become a very large positive number.

### Intuition

1. **State Tracking**: We maintain `maxSoFar` and `minSoFar` ending at the current index.
2. **Negative Numbers**: When we encounter a negative number, the `maxSoFar` multiplied by it becomes the new `minSoFar`, and the `minSoFar` multiplied by it becomes the new `maxSoFar`. Therefore, we **swap** `maxSoFar` and `minSoFar` before updating them.
3. **Transition**:
    - `maxSoFar = max(curr, maxSoFar * curr)`
    - `minSoFar = min(curr, minSoFar * curr)`
4. **Global Max**: Keep track of the maximum value of `maxSoFar` encountered during the iteration.

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the number of elements in the array. We traverse the array once.
- **Space Complexity:** $O(1)$, as we only use a few variables for tracking.

## Code (Java)

```java
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            
            // If current number is negative, swap max and min 
            // since we're looking for the largest product
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }
            
            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);
            
            result = Math.max(result, maxSoFar);
        }
        
        return result;
    }
}
```
