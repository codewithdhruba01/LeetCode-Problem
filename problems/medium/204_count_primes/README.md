# 204. Count Primes

[LeetCode Problem Link](https://leetcode.com/problems/count-primes/)

## Description

Given an integer `n`, return *the number of prime numbers that are strictly less than* `n`.

## Examples

**Example 1:**
```
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
```

**Example 2:**
```
Input: n = 0
Output: 0
```

**Example 3:**
```
Input: n = 1
Output: 0
```

## Constraints

- `0 <= n <= 5 * 10^6`

## Approach: Sieve of Eratosthenes

The most efficient way to count primes up to `n` is using the **Sieve of Eratosthenes**.

### Intuition

1. Create a boolean array `isPrime` of size `n`, initially assuming all numbers are prime.
2. Mark `isPrime[0]` and `isPrime[1]` as `false` (not prime).
3. Starting from `i = 2`, if `i` is prime, mark all its multiples starting from `i * i` as non-prime.
4. Continue until `i * i < n`.
5. Finally, count the number of `true` values in the `isPrime` array.

### Complexity Analysis

- **Time Complexity:** `O(N log log N)`, which is almost linear and much faster than trial division.
- **Space Complexity:** `O(N)` to store the boolean array.

## Code (Java)

```java
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark multiples of i starting from i * i
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }
}
```
