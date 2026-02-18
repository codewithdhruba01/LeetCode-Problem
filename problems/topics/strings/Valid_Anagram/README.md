# 242. Valid Anagram

[LeetCode Problem Link](https://leetcode.com/problems/valid-anagram/)

## Description

Given two strings `s` and `t`, return `true` if `t` is an **anagram** of `s`, and `false` otherwise.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Examples

**Example 1:**

```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Example 2:**

```
Input: s = "rat", t = "car"
Output: false
```

## Constraints

-   `1 <= s.length, t.length <= 5 * 10^4`
-   `s` and `t` consist of lowercase English letters.

## Approach: Frequency Array (Hash Table Strategy)

Since the input strings only contain lowercase English letters, we can use an integer array of size 26 to count the frequency of each character.

### Intuition

1.  If the lengths of `s` and `t` are different, they cannot be anagrams. Return `false`.
2.  Create an integer array `count` of size 26.
3.  Iterate through the string `s` and increment the count for each character.
    -   `count[s.charAt(i) - 'a']++`
4.  Iterate through the string `t` and decrement the count for each character.
    -   `count[t.charAt(i) - 'a']--`
5.  After processing both strings (or during the second pass), check if all counts are zero. If any count is non-zero (or strictly if we find a negative count during the second pass), return `false`.

### Complexity Analysis

-   **Time Complexity:** `O(N)`, where `N` is the length of the strings. We iterate through each string once.
-   **Space Complexity:** `O(1)`. The array size is fixed at 26, regardless of input size.

## Code (Java)

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}
```
