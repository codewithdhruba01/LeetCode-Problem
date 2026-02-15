# Revision Notes: Reverse Integer

## Core Concept
-   **Modulo & Division**: Use `% 10` to get the last digit and `/ 10` to truncate.
-   **Overflow Handling**: This is the most crucial part. Since we build the reversed number digit by digit, we must check if the next operation will cause an overflow *before* performing it.

## Algorithm Logic
```java
int rev = 0;
while (x != 0) {
    int digit = x % 10;
    x /= 10;
    
    // Check for potential overflow
    if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
    if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
    
    rev = rev * 10 + digit;
}
```

## Common Pitfalls
-   Assuming a 64-bit integer (`long`) is available. The problem specifically forbids it. If allowed, we could just use `long` and check if the result fits in `int` at the end.
-   Forgetting that negative numbers also need overflow checks (`Integer.MIN_VALUE`).
-   Incorrectly implementing the overflow check (e.g., checking *after* the overflow has occurred).

## Complexity
-   **Time**: `O(log(x))` - Number of digits.
-   **Space**: `O(1)` - Constant space.

## Key Points
-   The range of a 32-bit signed integer is `[-2^31, 2^31 - 1]`, which is `[-2147483648, 2147483647]`.
-   The last digit of `MAX_VALUE` is `7`.
-   The last digit of `MIN_VALUE` is `8` (magnitude).
