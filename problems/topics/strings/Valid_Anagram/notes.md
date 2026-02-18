# Revision Notes: Valid Anagram

## Core Concept
-   **Character Counting**: Anagrams must have the exact same count of every character.
-   **Fixed Size Array**: Since inputs are only lowercase English letters, `int[26]` is `O(1)` space and faster than a generic `HashMap`.

## Algorithm Logic
```java
if (s.length() != t.length()) return false;
int[] count = new int[26];
for (int i = 0; i < s.length(); i++) {
    count[s.charAt(i) - 'a']++;
    count[t.charAt(i) - 'a']--;
}
for (int c : count) if (c != 0) return false;
```

## Common Pitfalls
-   **Unequal Lengths**: Always check `s.length() != t.length()` first for immediate exit.
-   **Unicode Characters**: If the input contained Unicode characters (like emojis), `int[26]` wouldn't work. You'd need a `HashMap` or a larger array.

## Comparison
-   **Sorting**: You could sort both strings and compare (`O(N log N)`). This is acceptable but slower than the `O(N)` counting approach.
-   **HashMap**: Generic and handles all characters, but has higher overhead than a primitive array.
