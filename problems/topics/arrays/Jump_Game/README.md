# 55. Jump Game

[LeetCode Problem Link](https://leetcode.com/problems/jump-game/)

## Description

You are given an integer array `nums`. You are initially positioned at the array's **first index**, and each element in the array represents your maximum jump length at that position.

Return `true` if you can reach the last index, or `false` otherwise.

## Examples

**Example 1:**

```
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:**

```
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
```

## Constraints

-   `1 <= nums.length <= 10^4`
-   `0 <= nums[i] <= 10^5`

## Approach: Greedy

We can iterate through the array and keep track of the **maximum reachable index** (`maxReach`) at any point.

### Intuition

1.  Initialize `maxReach = 0`.
2.  Iterate through the array from `i = 0` to `n-1`.
3.  If the current index `i` is greater than `maxReach`, it means we cannot reach this index from any previous position. Return `false`.
4.  Update `maxReach` to be the maximum of current `maxReach` and `i + nums[i]` (the furthest we can go from current index `i`).
5.  If `maxReach` is greater than or equal to the last index (`n-1`), we can reach the end. Return `true`.
6.  If the loop finishes and we haven't returned `false`, generally it implies success, but the check inside loop handles the unreachable condition.

### Complexity Analysis

-   **Time Complexity:** `O(N)`. We traverse the array once.
-   **Space Complexity:** `O(1)`. We only use a single variable `maxReach`.

## Code (Java)

```java
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}
```
