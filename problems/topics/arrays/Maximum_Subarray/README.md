# 53. Maximum Subarray

[LeetCode Problem Link](https://leetcode.com/problems/maximum-subarray/)

## Description

Given an integer array `nums`, find the subarray with the largest sum, and return *its sum*.

## Examples

**Example 1:**

```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
```

**Example 2:**

```
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
```

**Example 3:**

```
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
```

## Constraints

-   `1 <= nums.length <= 10^5`
-   `-10^4 <= nums[i] <= 10^4`

## Approach: Kadane's Algorithm

The most efficient way to solve this problem is using **Kadane's Algorithm**.

### Intuition

The core idea is to look for all positive contiguous segments of the array (`currentSum`). If the sum of a subarray becomes negative, we discard it because adding a negative sum to the next element will only decrease the total sum. Instead, we restart the sum from the current element.

At each step, we update `currentSum` by adding the current element `nums[i]`.
However, if `currentSum` was negative before adding `nums[i]`, it is better to just start a new subarray beginning at `nums[i]` (because `negative_value + nums[i] < nums[i]`).

We also keep track of the `maxSum` encountered so far.

### Steps

1.  Initialize `currentSum` with the first element of the array.
2.  Initialize `maxSum` with the first element of the array.
3.  Iterate through the array starting from the second element (index 1).
4.  For each element `nums[i]`:
    -   Update `currentSum = Math.max(nums[i], currentSum + nums[i])`. This step decides whether to extend the existing subarray or start a new one.
    -   Update `maxSum = Math.max(maxSum, currentSum)`. This step records the maximum sum found so far.
5.  Return `maxSum`.

## Complexity Analysis

-   **Time Complexity:** `O(n)`, where `n` is the length of `nums`. We iterate through the array once.
-   **Space Complexity:** `O(1)`, as we only use a constant amount of extra space for variables `currentSum` and `maxSum`.

## Code (Java)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
```
