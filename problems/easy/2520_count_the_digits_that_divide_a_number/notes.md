# Revision Notes: Count the Digits That Divide a Number

## Core Concept
-   **Digit Extraction**: Use `num % 10` to get the last digit, then `num / 10` to remove it.
-   **Divisibility Check**: Check if `original % digit == 0`.

## Algorithm Logic
```java
int original = num;
int count = 0;

while (num > 0) {
    int digit = num % 10;
    if (original % digit == 0) {
        count++;
    }
    num = num / 10;
}
```

## Common Pitfalls
-   Forgetting to store the original value of `num` before modifying it in the loop.
-   Not handling the constraint that `num` does not contain `0` (though the problem guarantees this).

## Complexity
-   **Time**: `O(d)` - where `d` is the number of digits.
-   **Space**: `O(1)` - Constant extra space.

## Key Points
-   Simple digit manipulation problem.
-   Good practice for understanding modulo and integer division operations.
