# 1365. How Many Numbers Are Smaller Than the Current Number

[LeetCode Problem Link](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/)

## Description

Given the array `nums`, for each `nums[i]` find out how many numbers in the array are smaller than it. That is, for each `nums[i]` you have to count the number of valid `j`'s such that `j != i` and `nums[j] < nums[i]`.

Return the answer in an array.

## Examples

**Example 1:**
```
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
```

**Example 2:**
```
Input: nums = [6,5,4,8]
Output: [2,1,0,3]
```

**Example 3:**
```
Input: nums = [7,7,7,7]
Output: [0,0,0,0]
```

## Constraints

- `2 <= nums.length <= 500`
- `0 <= nums[i] <= 100`

## Approach: Frequency Array with Prefix Sums

A naive approach would compare every element against every other element, taking $O(N^2)$ time. A slightly better approach might sort the array, taking $O(N \log N)$ time.

However, noticing the tight constraint `0 <= nums[i] <= 100`, we can use a counting sort-like technique to solve this in $O(N)$ time.

### Intuition

1. **Count Frequencies**: Create an array `count` of size 101 (since values go up to 100). Iterate through `nums` and increment `count[num]` for each number. Now `count[Val]` stores how many times `Val` appears.
2. **Compute Prefix Sums**: We don't just want to know how many times a number appears; we want to know how many numbers are *smaller* than it. If we convert our `count` array into a prefix sum array, `count[Val]` will store the total number of elements that are $\le Val$.
   - Wait, we actually want strictly *smaller*. 
   - If `count[Val]` is the number of elements $\le Val$, then the number of elements strictly smaller than `Val` is `count[Val - 1]`.
3. **Build Result**: Iterate through the original `nums` array. For any element `val = nums[i]`, the count of smaller elements is `0` if `val == 0`, otherwise it is `count[val - 1]`.

### Complexity Analysis

- **Time Complexity:** $O(N + K)$, where $N$ is the length of `nums` and $K$ is the maximum possible value in `nums` (which is $100$ here). Since $K$ is a small constant, the time complexity simplifies to $O(N)$.
- **Space Complexity:** $O(K)$ to store the frequency array of size $101$, which simplifies to $O(1)$ extra space since it's a fixed size regardless of $N$. (The output array does not count as extra space).

## Code (Java)

```java
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // frequency array
        
        // Step 1: count frequency
        for (int num : nums) {
            count[num]++;
        }
        
        // Step 2: prefix sum (how many are <= current index)
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }
        
        // Step 3: build result
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = count[nums[i] - 1];
            }
        }
        
        return result;
    }
}
```
