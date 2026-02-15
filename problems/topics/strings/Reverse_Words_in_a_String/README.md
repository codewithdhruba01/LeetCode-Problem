# 151. Reverse Words in a String

[LeetCode Problem Link](https://leetcode.com/problems/reverse-words-in-a-string/)

## Description

Given an input string `s`, reverse the order of the **words**.

A **word** is defined as a sequence of non-space characters. The **words** in `s` will be separated by at least one space.

Return *a string of the words in reverse order concatenated by a single space.*

**Note** that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

## Examples

**Example 1:**

```
Input: s = "the sky is blue"
Output: "blue is sky the"
```

**Example 2:**

```
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
```

**Example 3:**

```
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
```

## Constraints

-   `1 <= s.length <= 10^4`
-   `s` contains English letters (upper-case and lower-case), digits, and spaces `' '`.
-   There is **at least one** word in `s`.

## Approach: Reverse Iteration (Two Pointers)

The most memory-efficient approach (if mutable strings were allowed in Java) would be to reverse the entire string, then reverse each word. However, since strings are immutable in Java, we can iterate from the end of the string to the beginning.

### Intuition

1.  Traverse the string `s` from the last character to the first (`i` goes from `n-1` to `0`).
2.  Skip trailing spaces.
3.  Identify the end of a word (`i`).
4.  Continue moving backwards to find the start of the word (`j` goes from `i` down to `0`).
5.  Extract the word substring `s.substring(i + 1, j + 1)` and append it to a `StringBuilder`.
6.  Add a space after the word (only if it's not the first word added).
7.  Repeat until the beginning of the string is reached.
8.  Return the built string (trimmed if necessary).

### Complexity Analysis

-   **Time Complexity:** `O(N)`, where `N` is the length of `s`. We traverse the string once.
-   **Space Complexity:** `O(N)`, to store the result string.

## Code (Java)

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;

            int j = i; // End of the word
            // Find start of the word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Append word
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(s.substring(i + 1, j + 1));
        }

        return result.toString();
    }
}
```
