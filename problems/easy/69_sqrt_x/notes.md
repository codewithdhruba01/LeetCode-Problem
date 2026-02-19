# Revision Notes: Sqrt(x)

## Core Concept
-   **Binary Search on Answer**: Since the square root function is monotonic (increasing), we can search for the answer in the range `[1, x]`.

## Algorithm Logic
```java
if (x < 2) return x;
int left = 1, right = x / 2;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (mid == x / mid) return mid;
    else if (mid < x / mid) left = mid + 1;
    else right = mid - 1;
}
return right;
```

## Common Pitfalls
-   **Integer Overflow**: Calculating `mid * mid` can exceed `Integer.MAX_VALUE`.
    -   **Fix**: Use `mid == x / mid` or `long` for the product. Division is safer and cleaner here.
-   **Returning the correct value**: The problem asks for rounding **down**.
    -   When the loop `while (left <= right)` terminates, `left` will be `right + 1`.
    -   `right` will be the largest integer such that `right * right <= x`. This is exactly what we need.

## Complexity
-   **Time**: `O(log x)` - Standard binary search.
-   **Space**: `O(1)` - Constant space.
