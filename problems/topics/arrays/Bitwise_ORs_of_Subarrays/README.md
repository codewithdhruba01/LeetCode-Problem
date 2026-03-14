# 898. Bitwise ORs of Subarrays

[LeetCode Problem Link](https://leetcode.com/problems/bitwise-ors-of-subarrays/)

## Description

Given an integer array `arr`, return *the number of distinct bitwise ORs of all the non-empty subarrays of* `arr`.

The **bitwise OR** of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.

A **subarray** is a contiguous non-empty sequence of elements within an array.

## Examples

**Example 1:**
```
Input: arr = [0]
Output: 1
Explanation: There is only one possible result: 0.
```

**Example 2:**
```
Input: arr = [1,1,2]
Output: 3
Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values, so the answer is 3.
```

**Example 3:**
```
Input: arr = [1,2,4]
Output: 6
Explanation: The possible results are 1, 2, 3, 4, 6, and 7.
```

## Constraints

- `1 <= arr.length <= 5 * 10^4`
- `0 <= arr[i] <= 10^9`

## Approach: HashSet with Dynamic Programming

The naive approach of calculating the OR for every $O(N^2)$ subarray would be too slow ($O(N^2)$ time). We can optimize this by leveraging a key property of the bitwise OR operation.

### Intuition

When we take the bitwise OR of an integer with other integers, the number of set bits (1s) can only monotonically increase or stay the same. Since integers in this problem are up to $10^9$, they have at most 30 bits. Therefore, starting from any index `i`, as we extend the subarray to the right, the accumulated bitwise OR value can change at most 30 times. 

This means at any point `i` ending at the current element `arr[i]`, the unique bitwise ORs of all subarrays ending exactly at `i` is bounded by $\sim 30$.

1. We maintain a `result` HashSet to collect all naturally unique OR values across the entire array.
2. We iterate through `arr`. For each element `num`, we maintain a `curr` HashSet which will store all unique OR values of subarrays ending *exactly* at the current element.
3. To build `curr`, we take the previous step's set (`prev`), which contains unique OR values ending at the previous element. For each value `val` in `prev`, `val | num` will be a unique OR value ending at the current element. We add this, along with just `num` itself (representing a subarray of length 1 ending here) into `curr`.
4. We add all values from `curr` to our global `result` set.
5. In the next iteration, our current `curr` becomes the new `prev`.

### Complexity Analysis

- **Time Complexity:** $O(N \log (\max A))$, where $N$ is `arr.length` and $\max A$ is the maximum value in `arr`. The inner loop iterates over `prev`, whose size is bounded by the number of bits in the maximum possible value ($\sim 30$ for $10^9$). Let this max bits be $B=30$. The time complexity is practically $O(30 \cdot N)$ which is linear $O(N)$.
- **Space Complexity:** $O(N \log (\max A))$ to store the `result` HashSets. The size of `result` is at most $N \cdot 30$ unique values, though usually much smaller. `prev` and `curr` take $O(30)$ space, which is $O(1)$. Therefore, practically $O(N)$ space.

## Code (Java)

```java
import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        
        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);
            
            for (int val : prev) {
                curr.add(val | num);
            }
            
            result.addAll(curr);
            prev = curr;
        }
        
        return result.size();
    }
}
```
