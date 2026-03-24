# 169. Majority Element

[LeetCode Problem Link](https://leetcode.com/problems/majority-element/)

## Description

Given an array `nums` of size `n`, return *the majority element*.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

## Examples

**Example 1:**
```
Input: nums = [3,2,3]
Output: 3
```

**Example 2:**
```
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

## Constraints

- `n == nums.length`
- `1 <= n <= 5 * 10^4`
- `-10^9 <= nums[i] <= 10^9`

## Approach: Boyer-Moore Voting Algorithm

While we could use a HashMap to count frequencies ($O(N)$ time, $O(N)$ space), this problem can be solved in $O(1)$ extra space using the Boyer-Moore Voting Algorithm.

### Intuition

The Boyer-Moore algorithm identifies a potential majority element candidate in a single pass. It works on the principle that if we cancel out each occurrence of an element with all other elements that are different from it, then at the end, the majority element will remain (because it occurs more than half the time).

1. **Initialize**: A `candidate` to store our potential majority element and a `count` initialized to 0.
2. **Iterate**: For each number `num` in `nums`:
   - If `count` is 0, we set the current `num` as our new `candidate`.
   - If `num` is equal to `candidate`, we increment `count`.
   - Otherwise, we decrement `count`.
3. **Return**: The `candidate` after one full pass.

Since the problem guarantees that a majority element always exists, the final `candidate` will be the answer.

### Complexity Analysis

- **Time Complexity:** $O(N)$. We make exactly one pass through the array.
- **Space Complexity:** $O(1)$. We only use two variables (`candidate` and `count`).

## Code (Java)

```java
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}
```
