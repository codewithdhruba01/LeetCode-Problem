# 2520. Count the Digits That Divide a Number

[LeetCode Problem Link](https://leetcode.com/problems/count-the-digits-that-divide-a-number/)

## Description

Given an integer `num`, return *the number of digits in* `num` *that divide* `num`.

An integer `val` divides `nums` if `nums % val == 0`.

## Examples

**Example 1:**

```
Input: num = 7
Output: 1
Explanation: 7 divides itself, hence the answer is 1.
```

**Example 2:**

```
Input: num = 121
Output: 2
Explanation: 121 is divisible by 1, but not 2. Since 1 occurs twice as a digit, we return 2.
```

**Example 3:**

```
Input: num = 1248
Output: 4
Explanation: 1248 is divisible by all of its digits, hence the answer is 4.
```

## Constraints

-   `1 <= num <= 10^9`
-   `num` does not contain `0` as one of its digits.

## Approach: Digit Extraction

The approach is straightforward:
1.  Extract each digit from the number.
2.  Check if the original number is divisible by that digit.
3.  Count how many digits divide the number.

### Intuition

We can extract digits by repeatedly taking `num % 10` to get the last digit, then dividing `num` by `10` to remove it. For each digit, we check if `original % digit == 0`. If yes, we increment our count.

### Complexity Analysis

-   **Time Complexity:** `O(d)`, where `d` is the number of digits in `num`. We process each digit once.
-   **Space Complexity:** `O(1)`, as we only use a constant amount of extra space.

## Code (Java)

```java
class Solution {
    public int countDigits(int num) {
        int original = num;
        int count = 0;
        
        while (num > 0) {
            int digit = num % 10;
            if (original % digit == 0) {
                count++;
            }
            num = num / 10;
        }
        
        return count;
    }
}
```
