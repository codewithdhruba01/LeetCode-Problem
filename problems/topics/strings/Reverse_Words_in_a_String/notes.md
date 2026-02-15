# Revision Notes: Reverse Words in a String

## Core Concept
-   **Reverse Iteration**: Scan the string from right to left.
-   **Two Pointers (Implicit)**: `i` for current position, `j` for end of word.
-   **Handling Spaces**: Specifically skipping multiple spaces is crucial.

## Algorithm Logic
```java
while (i >= 0) {
    while (i >= 0 && s.charAt(i) == ' ') i--; // Skip trailing spaces
    if (i < 0) break;
    int j = i; // End of word
    while (i >= 0 && s.charAt(i) != ' ') i--; // Find start of word
    
    if (result.length() > 0) result.append(" ");
    result.append(s.substring(i + 1, j + 1));
}
```

## Common Pitfalls
-   Not handling leading/trailing spaces correctly.
-   Adding an extra space at the end/beginning of the result string.
-   Not checking `i >= 0` inside the inner `while` loops (IndexOutOfBoundsException).

## Complexity
-   **Time**: `O(N)` - Linear scan.
-   **Space**: `O(N)` - To store the result.

## Alternative Approaches
-   **Built-in Split**: `s.trim().split("\\s+")` then reverse the array. Easier to write but less optimal due to regex overhead and multiple allocations.
-   **Double Reverse**: Reverse the whole string, then reverse each word individually. (Requires mutable string or char array). `O(1)` space if `s` is mutable (like C++ `std::string`).
