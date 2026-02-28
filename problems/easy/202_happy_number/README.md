# 202. Happy Number

[LeetCode Problem Link](https://leetcode.com/problems/happy-number/)

## Description

Write an algorithm to determine if a number `n` is happy.

A **happy number** is a number defined by the following process:

- Starting with any positive integer, replace the number by the sum of the squares of its digits.
- Repeat the process until the number equals 1 (where it will stay), or it **loops endlessly in a cycle** which does not include 1.
- Those numbers for which this process **ends in 1** are happy.

Return `true` if `n` is a happy number, and `false` if not.

## Examples

**Example 1:**
```
Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
```

**Example 2:**
```
Input: n = 2
Output: false
```

## Constraints

- `1 <= n <= 2^31 - 1`

## Approach: Floyd's Cycle-Finding Algorithm (Slow and Fast Pointers)

The problem states that the process either ends in `1` or loops endlessly in a cycle. This is a classic cycle detection problem.

### Intuition

We can treat the sequence of numbers generated as a linked list where each number points to the next number in the sequence (sum of squares of digits).
- If there is a cycle that doesn't include `1`, the slow and fast pointers will eventually meet at some number other than `1`.
- If the sequence reaches `1`, it will stay at `1` (as 1^2 = 1), and both pointers will eventually reach `1`.

### Complexity Analysis

- **Time Complexity:** `O(log N)`. The number of digits in a number `n` is `log10(N)`, and the sum of squares of digits decreases very quickly for large numbers.
- **Space Complexity:** `O(1)`. We only store two pointers.

## Code (Java)

```java
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
```
