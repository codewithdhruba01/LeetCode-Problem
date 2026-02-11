# 14. Longest Common Prefix

[LeetCode Problem Link](https://leetcode.com/problems/longest-common-prefix/)

## Description

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

## Examples

**Example 1:**

```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

**Example 2:**

```
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

## Constraints

-   `1 <= strs.length <= 200`
-   `0 <= strs[i].length <= 200`
-   `strs[i]` consists of only lowercase English letters if it is non-empty.

## Approach: Horizontal Scanning

The idea is to take the first string as a reference `prefix` and compare it with the second string, updating the `prefix`. Then compare the updated `prefix` with the third string, and so on.

### Intuition

1.  Start by assuming the first string `strs[0]` is the **Longest Common Prefix (LCP)**.
2.  Iterate through the rest of the strings in the array.
3.  For each string `strs[i]`, check if it starts with the current `prefix`.
4.  If it doesn't, shorten the `prefix` by removing the last character until `strs[i]` starts with it.
5.  If `prefix` becomes empty during this process, return `""` immediately.
6.  Finally, return the `prefix`.

### Complexity Analysis

-   **Time Complexity:** `O(S)`, where `S` is the sum of all characters in all strings. In the worst case, all strings are identical.
-   **Space Complexity:** `O(1)`, as we only use a constant amount of extra space for the `prefix` variable (ignoring the result storage).

## Code (Java)

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        
        return prefix;
    }
}
```
