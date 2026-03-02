# 58. Length of Last Word

[LeetCode Problem Link](https://leetcode.com/problems/length-of-last-word/)

## Description

Given a string `s` consisting of words and spaces, return the *length of the **last** word in the string.*

A **word** is a maximal substring consisting of non-space characters only.

## Examples

**Example 1:**
```
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
```

**Example 2:**
```
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
```

**Example 3:**
```
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
```

## Constraints

- `1 <= s.length <= 10^4`
- `s` consists of only English letters and spaces `' '`.
- There will be at least one word in `s`.

## Approach: Right-to-Left Traversal

Since we only need the length of the *last* word, it is most efficient to start scanning the string from the end.

### Intuition

1. **Step 1: Skip trailing spaces.** Start from the end of the string and move backwards as long as we encounter spaces.
2. **Step 2: Count characters.** Once we hit a non-space character, we've found the end of the last word. Continue moving backwards and incrementing a counter until we hit another space or the beginning of the string.
3. Return the counter.

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the string. In the worst case, we might traverse the entire string once.
- **Space Complexity:** `O(1)`, as we only use a few integer variables.

## Code (Java)

```java
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Step 1: Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
```
