# Revision Notes: Integer to Roman

## Core Concept
-   **Greedy Approach**: Map values to symbols and always try to fit the largest value possible.
-   **Lookup Tables**: Defining standard values (`1000, 500, 100...`) along with special subtractive pairs (`900, 400, 90, 40...`) simplifies the logic significantly.

## Algorithm Logic
```java
int[] values = {1000, 900, 500, 400, ...};
String[] symbols = {"M", "CM", "D", "CD", ...};

for (int i = 0; i < values.length; i++) {
    while (num >= values[i]) {
        result.append(symbols[i]);
        num -= values[i];
    }
}
```

## Common Pitfalls
-   Forgetting to include the subtractive forms (`IV`, `IX`, etc.) in the lookup arrays. Without them, you need complex logic to handle cases like `4` or `9`.
-   Not ordering the lookup arrays in **descending** order. The greedy approach relies on trying larger values first.

## Complexity
-   **Time**: `O(1)` - Since `num <= 3999`, the inner `while` loop runs a bounded number of times. The max length of a Roman Numeral in this range is 15 (e.g., 3888 is MMMDCCCLXXXVIII).
-   **Space**: `O(1)` - Fixed size arrays.
