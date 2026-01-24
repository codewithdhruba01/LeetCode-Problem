# Two Pointers Pattern

The Two Pointers pattern involves using two pointers to iterate through data structures (usually arrays or strings).

## Common Variations
1. **Opposite Ends**: One pointer starts at the beginning, and the other at the end. They move towards each other (e.g., used for palindromes).
2. **Fast and Slow**: One pointer moves faster than the other (e.g., used for detecting cycles in linked lists).

## Why use it?
It often reduces the time complexity from O(n²) to O(n) by avoiding redundant iterations.

### Example: [Palindrome Number](file:///home/dhrubaraj-pati/Desktop/LeetCode-problem/problems/easy/9_palindrome_number)
While moving towards the center from both ends, compare the characters/digits at each pointer.
