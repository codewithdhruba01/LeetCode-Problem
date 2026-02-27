# 387. First Unique Character in a String

[LeetCode Problem Link](https://leetcode.com/problems/first-unique-character-in-a-string/)

## Description

Given a string `s`, find the first non-repeating character in it and return its index. If it does not exist, return `-1`.

## Examples

**Example 1:**
```
Input: s = "leetcode"
Output: 0
Explanation: The character 'l' at index 0 is the first character that does not occur at any other index.
```

**Example 2:**
```
Input: s = "loveleetcode"
Output: 2
```

**Example 3:**
```
Input: s = "aabb"
Output: -1
```

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of only lowercase English letters.

## Approach: Frequency Array (Hashing)

Since the input only contains lowercase English letters, we can use an integer array of size 26 to store the frequency of each character.

### Intuition

1. **First Pass**: Traverse the string once to count the occurrences of each character and store them in the frequency array.
2. **Second Pass**: Traverse the string again from left to right. For each character, check its frequency in the array. The first character with a frequency of `1` is the first unique character. Return its index.
3. If no such character is found, return `-1`.

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the string. We perform two linear passes over the string.
- **Space Complexity:** `O(1)`, as the frequency array always has a fixed size of 26, regardless of the input string length.

## Code (Java)

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
```
