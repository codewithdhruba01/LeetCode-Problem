# 50. Pow(x, n)

[LeetCode Problem Link](https://leetcode.com/problems/powx-n/)

## Description

Implement [pow(x, n)](http://www.cplusplus.com/reference/valarray/pow/), which calculates `x` raised to the power `n` (i.e., `x^n`).

## Examples

**Example 1:**

```
Input: x = 2.00000, n = 10
Output: 1024.00000
```

**Example 2:**

```
Input: x = 2.10000, n = 3
Output: 9.26100
```

**Example 3:**

```
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
```

## Constraints

-   `-100.0 < x < 100.0`
-   `-2^31 <= n <= 2^31 - 1`
-   `n` is an integer.
-   Either `x` is not zero or `n > 0`.
-   `-10^4 <= x^n <= 10^4`

## Approach: Binary Exponentiation (Iterative)

Calculating `x^n` naively would take `O(n)` time, which is too slow (Time Limit Exceeded) for large `n`. We can use **Binary Exponentiation** to compute the power in `O(log n)` time.

### Intuition

The idea is to square the base `x` and halve the exponent `n` at each step.
-   If `n` is even: `x^n = (x^2)^(n/2)`
-   If `n` is odd: `x^n = x * (x^2)^((n-1)/2)`

We iterate while `n > 0`. If the current bit of `n` is set (odd `n`), we multiply the result by the current `x`. Then we update `x` to `x * x` and shift `n` right by 1 (`n /= 2`).

### Handling Negative Powers and Overflow

-   If `n` is negative, we calculate `(1/x)^(-n)`. So, `x = 1/x` and `power = -n`.
-   **Critical Edge Case**: If `n = Integer.MIN_VALUE` (`-2147483648`), directly negating it will overflow `int`. Therefore, we should store `n` in a `long` variable before negating it.

### Complexity Analysis

-   **Time Complexity:** `O(log n)`. The exponent is halved at each step.
-   **Space Complexity:** `O(1)`. We only use a few variables.

## Code (Java)

```java
class Solution {
    public double myPow(double x, int n) {
        long power = n;
        double result = 1.0;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        while (power > 0) {
            if ((power & 1) == 1) { // If power is odd
                result *= x;
            }
            x *= x;
            power >>= 1; // Divide power by 2
        }

        return result;
    }
}
```
