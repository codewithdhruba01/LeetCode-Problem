# 560. Subarray Sum Equals K

[LeetCode Problem Link](https://leetcode.com/problems/subarray-sum-equals-k/)

## Description

Given an array of integers `nums` and an integer `k`, return *the total number of subarrays whose sum equals to* `k`.

A subarray is a contiguous **non-empty** sequence of elements within an array.

## Examples

**Example 1:**

```
Input: nums = [1,1,1], k = 2
Output: 2
```

**Example 2:**

```
Input: nums = [1,2,3], k = 3
Output: 2
```

## Constraints

-   `1 <= nums.length <= 2 * 10^4`
-   `-1000 <= nums[i] <= 1000`
-   `-10^7 <= k <= 10^7`

## Approach: HashMap with Prefix Sum

This problem can be efficiently solved using a **HashMap** to store prefix sums and their frequencies.

### Intuition

The key insight is that if we know the cumulative sum up to index `i` is `sum`, and we've previously seen a cumulative sum of `sum - k` at some earlier index, then the subarray between those two indices has a sum of `k`.

**Steps:**
1.  Use a HashMap to store the frequency of each prefix sum encountered.
2.  Initialize the HashMap with `{0: 1}` to handle cases where a prefix sum itself equals `k`.
3.  Iterate through the array, maintaining a running `sum`.
4.  For each element:
    -   Check if `sum - k` exists in the HashMap. If yes, add its frequency to the count (these are valid subarrays ending at the current index).
    -   Add the current `sum` to the HashMap (or increment its frequency if it already exists).

### Complexity Analysis

-   **Time Complexity:** `O(n)`, where `n` is the length of `nums`. We iterate through the array once.
-   **Space Complexity:** `O(n)`, for the HashMap storing prefix sums.

## Code (Java)

```java
import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Important: base case

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
```
