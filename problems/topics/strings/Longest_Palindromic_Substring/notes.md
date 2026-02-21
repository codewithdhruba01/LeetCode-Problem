# Revision Notes: Longest Palindromic Substring

## Core Intuition: Expansion
- A palindrome is symmetric. This symmetry can be explored by starting from a "center" and moving outward.
- **Why centers?** Every palindrome must have a center.
- **Odd vs Even:** 
    - Odd-length: Center is a character (e.g., `aba` center is `b`).
    - Even-length: Center is between two characters (e.g., `abba` center is between `b` and `b`).

## Edge Cases to Remember
- `s == null` or `s.length() == 0`.
- String of length 1 (is always a palindrome).
- String with all same characters (e.g., `aaaaa`).
- String with no palindromes longer than 1 (return the first character).

## Algorithm Logic Highlights
- Iterate through each character as a potential center.
- Call `expandAroundCenter` twice for each center to handle both odd and even lengths.
- Length of palindrome calculation: `right - left - 1` (after the while loop fails, `left` and `right` are one step beyond the palindrome boundaries).
- Start index: `i - (len - 1) / 2`.
- End index: `i + len / 2`.

## Time & Space Complexity
- **Time**: `O(N^2)` — Loop over `N` characters, each expansion takes `O(N)`.
- **Space**: `O(1)` — Only pointers used, no extra data structure (unlike Dynamic Programming approach which takes `O(N^2)` space).

## Alternatives
- **Dynamic Programming**: `O(N^2)` time and `O(N^2)` space. Useful for understanding state transitions but less efficient spatially.
- **Manacher's Algorithm**: `O(N)` time and `O(N)` space. Highly optimized but significantly more complex to implement.
- **Suffix Trees**: Can also solve it in linear time but is overkill for interviews.
