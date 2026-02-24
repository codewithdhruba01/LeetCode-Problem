# Revision Notes: Rotate String

## Core Concept
- **Rotation Definition**: A string `s` is a rotation of `goal` if `s` can be transformed into `goal` by moving some number of characters from the beginning to the end.
- **Modulo Arithmetic**: The key to simulating rotation without extra space is using the formula `(i + shift) % n`.

## Algorithm Logic (Brute Force)
1. Check if lengths are equal.
2. Iterate through all possible shifts (`shift` from `0` to `n-1`).
3. For each shift, check if `s.charAt((i + shift) % n) == goal.charAt(i)` for all `i`.
4. If a full match is found, return `true`.

## Optimized Approach (O(N))
- A more elegant way to solve this is to check if `goal` is a substring of `s + s`.
- **Reasoning**: If you concatenate `s` with itself, all possible rotations of `s` will appear as substrings in the resulting string.
- **Example**: `s = "abcde"`, `s + s = "abcdeabcde"`. Rotations like `"cdeab"` are contained within it.

```java
public boolean rotateString(String s, String goal) {
    return s.length() == goal.length() && (s + s).contains(goal);
}
```

## Common Pitfalls
- **Length Check**: Forgetting to check if lengths are the same. `(s+s).contains(goal)` would return `true` for `s="abc"`, `goal="ab"` if lengths aren't checked.
- **Modulo vs Substring**: While the substring method is faster to write, the modulo method (brute force) uses less space (`O(1)` vs `O(N)` for the concatenated string).

## Complexity
- **Brute Force**: Time `O(N^2)`, Space `O(1)`.
- **Substring Method**: Time `O(N)`, Space `O(N)`.
