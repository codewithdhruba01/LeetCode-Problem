# Revision Notes: Remove Letter To Equalize Frequency

## Core Concept
- **Small Constraints**: The string length is at most 100, which suggests that a brute force approach `O(N^2)` is perfectly acceptable and often cleaner than complex case-by-case analysis.
- **Frequency Validation**: After removing one letter, all *remaining* letters must have the same count.

## Algorithm Logic
1. Loop through each character index `i` in the word.
2. For each `i`, create a frequency array `freq[26]`.
3. Count frequencies of `word[j]` where `j != i`.
4. Iterate through `freq`:
   - Identify the first non-zero frequency as the `target`.
   - If any other non-zero frequency != `target`, the removal at index `i` is invalid.
5. If any removal results in a valid configuration, return `true`.

## Key Insights
- **Exactly One Removal**: The problem mandates removing one character. This makes it a great candidate for brute force when `N` is small.
- **Edge Cases**:
  - `aaaa`: Removing one `a` leaves 3 `a`s. All letters (only `a`) have frequency 3. Result: `true`.
  - `abc`: Removing any letter leaves two letters with frequency 1. Result: `true`.
  - `aazz`: Removing any letter leaves one letter with freq 1 and another with freq 2. Result: `false`.

## Complexity
- **Time Complexity**: `O(N * N)` where `N` is word length. For each of the `N` positions, we scan the word of length `N`.
- **Space Complexity**: `O(1)` as we use a fixed size frequency array of 26.
