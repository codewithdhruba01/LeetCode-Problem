# Revision Notes: Pow(x, n)

## Core Concept
-   **Binary Exponentiation (Exponentiation by Squaring)**: Compute power in `O(log n)` time.
-   **Iterative Approach**: Usually preferred over recursive to avoid stack overflow risks (though recursion depth is small here `~31`).

## Algorithm Logic
```java
long power = n; // Use long to handle Integer.MIN_VALUE
if (power < 0) {
    x = 1 / x;
    power = -power;
}
while (power > 0) {
    if ((power & 1) == 1) result *= x; // If odd, multiply result
    x *= x; // Square the base
    power >>= 1; // Divide power by 2
}
```

## Common Pitfalls
-   **Integer Overflow**: `n` can be `Integer.MIN_VALUE` (`-2147483648`). If you do `-n`, it overflows back to `Integer.MIN_VALUE` because `Integer.MAX_VALUE` is `2147483647`. **Always cast `n` to `long` first.**
-   **Negative Powers**: Remember to invert `x` (`x = 1/x`) and make `n` positive.
-   **Time Limit Exceeded**: Using a simple `for` loop `O(n)` will TLE.

## Complexity
-   **Time**: `O(log n)` - We halve the exponent in each step.
-   **Space**: `O(1)` - Constant space.

## Key Points
-   Use `long` for power.
-   Use bitwise operators (`& 1`, `>>= 1`) for slightly better performance (though compiler often optimizes standard operations too).
