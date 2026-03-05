# 2423. Remove Letter To Equalize Frequency

[LeetCode Problem Link](https://leetcode.com/problems/remove-letter-to-equalize-frequency/)

## Description

You are given a **0-indexed** string `word`, consisting of lowercase English letters. You need to select **one** index and **remove** the letter at that index from `word` so that the frequency of every letter present in `word` is equal.

Return `true` if it is possible to remove one letter so that the frequency of all letters in `word` are equal, and `false` otherwise.

**Note:**

- The **frequency** of a letter `x` is the number of times it occurs in the string.
- You must remove **exactly** one letter and cannot choose to do nothing.

## Examples

**Example 1:**
```
Input: word = "abcc"
Output: true
Explanation: Select index 3 and delete it: word becomes "abc" and each character has a frequency of 1.
```

**Example 2:**
```
Input: word = "aazz"
Output: false
Explanation: We must delete a character, so either the frequency of "a" is 1 and the frequency of "z" is 2, or vice versa. It is impossible to make all present letters have equal frequency.
```

## Constraints

- `2 <= word.length <= 100`
- `word` consists of lowercase English letters only.

## Approach: Brute Force (Try Removing Each Letter)

Since the length of the string is very small (at most 100), we can try removing each character one by one and check if the remaining characters have the same frequency.

### Intuition

1. Iterate through each index `i` of the string.
2. For each `i`, pretend we removed `word.charAt(i)`.
3. Count the frequencies of all remaining characters in an array of size 26.
4. Check if all non-zero frequencies are equal:
   - Find the first non-zero frequency as a `target`.
   - Ensure every other non-zero frequency matches this `target`.
5. If any removal results in equal frequencies, return `true`.
6. If no such removal works, return `false`.

### Complexity Analysis

- **Time Complexity:** `O(N * N)`, where `N` is the length of the string. We iterate `N` times, and for each removal, we iterate `N` times to count frequencies. The final check takes `O(26)`. Given `N <= 100`, this is very efficient.
- **Space Complexity:** `O(1)`, as the frequency array always has a fixed size of 26.

## Code (Java)

```java
class Solution {
    public boolean equalFrequency(String word) {
        // Try removing each character at index i
        for (int i = 0; i < word.length(); i++) {
            int[] freq = new int[26];
            
            // Count frequencies of characters except the one at index i
            for (int j = 0; j < word.length(); j++) {
                if (i == j) continue;
                freq[word.charAt(j) - 'a']++;
            }
            
            // Check if all present frequencies are equal
            int target = 0;
            boolean valid = true;
            for (int f : freq) {
                if (f == 0) continue;
                if (target == 0) target = f;
                else if (target != f) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) return true;
        }
        
        return false;
    }
}
```
