# 238. Product of Array Except Self

[LeetCode Problem Link](https://leetcode.com/problems/product-of-array-except-self/)

## Description

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.

You must write an algorithm that runs in `O(n)` time and without using the division operation.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

**Example 2:**
```
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```

## Constraints

- `2 <= nums.length <= 10^5`
- `-30 <= nums[i] <= 30`
- The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.

**Follow up:** Can you solve the problem in `O(1)` extra space complexity? (The output array **does not** count as extra space for space complexity analysis.)

## Approach: Prefix and Suffix Products (with Space Optimization)

The naive way to solve this without division would be to use two arrays: `prefixProducts` and `suffixProducts`. 
- `prefixProducts[i]` contains the product of all elements to the *left* of `i`.
- `suffixProducts[i]` contains the product of all elements to the *right* of `i`.
- The final answer at `i` is simply `prefixProducts[i] * suffixProducts[i]`.

However, we can optimize space to `O(1)` (excluding the output array) by using the output array itself to store the prefix products initially, and then dynamically calculating the suffix products on the fly while traversing the array backward.

### Intuition

**Step 1: Compute Prefix Products in Result Array**
1. Initialize the `result` array. We will temporarily use this to store prefix products.
2. Since there are no elements to the left of index 0, set `result[0] = 1`.
3. Loop from `i = 1` to `n - 1`: Calculate `result[i] = result[i - 1] * nums[i - 1]`. Now `result[i]` holds the product of all elements to the left of `i`.

**Step 2: Compute Suffix Products and Final Result Simultaneously**
1. Initialize a variable `suffix = 1`. This will track the running product of elements to the right.
2. Loop backwards from `i = n - 1` down to 0:
   - The final answer for index `i` is the prefix product (currently stored in `result[i]`) multiplied by the running `suffix`. So, `result[i] = result[i] * suffix`.
   - Update `suffix` for the next iteration by multiplying it with the current element: `suffix *= nums[i]`.
3. The `result` array now holds the correct final answers.

### Complexity Analysis

- **Time Complexity:** `O(N)`. We iterate through the array of length `N` exactly twice (once forward, once backward). $O(N) + O(N) = O(N)$.
- **Space Complexity:** `O(1)` extra space. The problem states that the output array (`result`) does not count towards extra space. The only auxiliary variable used is the integer `suffix`.

## Code (Java)

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Step 1: prefix product
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Step 2: suffix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }
        
        return result;
    }
}
```
