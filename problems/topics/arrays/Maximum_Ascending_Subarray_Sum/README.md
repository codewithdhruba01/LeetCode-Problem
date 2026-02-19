# 1800. Maximum Ascending Subarray Sum

[LeetCode Problem Link](https://leetcode.com/problems/maximum-ascending-subarray-sum/)

## Description

Given an array of positive integers `nums`, return the maximum possible sum of an **strictly increasing subarray** in `nums`.

A subarray is defined as a contiguous sequence of numbers in an array.

## Examples

**Example 1:**

```
Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
```

**Example 2:**

```
Input: nums = [10,20,30,40,50]
Output: 150
Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
```

**Example 3:**

```
Input: nums = [12,17,15,13,10,11,12]
Output: 33
Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.
```

## Constraints

-   `1 <= nums.length <= 100`
-   `1 <= nums[i] <= 100`

## Approach: Linear Scan

We can solve this problem in a single pass. We keep track of the `currentSum` of the current ascending subarray and update the global `maxSum` variable.

### Intuition

1.  Initialize `currentSum = nums[0]` and `maxSum = nums[0]`.
2.  Iterate through the array starting from the second element (`i = 1`).
3.  If `nums[i] > nums[i-1]`, it means the ascending sequence continues. Add `nums[i]` to `currentSum`.
4.  If `nums[i] <= nums[i-1]`, the ascending sequence breaks. Reset `currentSum` to `nums[i]` (starting a new subarray).
5.  At each step (or when the sequence breaks), update `maxSum = Math.max(maxSum, currentSum)`.
6.  Return `maxSum`.

### Complexity Analysis

-   **Time Complexity:** `O(N)`. We iterate through the array once.
-   **Space Complexity:** `O(1)`. We only use a few variables.

## Code (Java)

```java
class Solution {
    public int maxAscendingSum(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
```
