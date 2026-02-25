# 412. Fizz Buzz

[LeetCode Problem Link](https://leetcode.com/problems/fizz-buzz/)

## Description

Given an integer `n`, return a string array `answer` (**1-indexed**) where:

- `answer[i] == "FizzBuzz"` if `i` is divisible by `3` and `5`.
- `answer[i] == "Fizz"` if `i` is divisible by `3`.
- `answer[i] == "Buzz"` if `i` is divisible by `5`.
- `answer[i] == i` (as a string) if none of the above conditions are true.

## Examples

**Example 1:**
```
Input: n = 3
Output: ["1","2","Fizz"]
```

**Example 2:**
```
Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
```

**Example 3:**
```
Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
```

## Constraints

- `1 <= n <= 10^4`

## Approach: String Concatenation

The most flexible approach is string concatenation. This is particularly useful if more conditions are added later (e.g., "7 replaces with Jazz").

### Intuition

1. Iterate from `1` to `n`.
2. For each number, initialize an empty string.
3. If divisible by `3`, append "Fizz".
4. If divisible by `5`, append "Buzz".
5. If the string is still empty, it means none of the above were true, so append the number itself.
6. Add the final string to our result list.

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the input integer. We iterate through each number once.
- **Space Complexity:** `O(1)` (excluding the output list) or `O(N)` if including the space required for the output list.

## Code (Java)

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            String s = "";

            if (i % 3 == 0) s += "Fizz";
            if (i % 5 == 0) s += "Buzz";

            if (s.isEmpty()) {
                s = String.valueOf(i);
            }

            result.add(s);
        }

        return result;
    }
}
```
