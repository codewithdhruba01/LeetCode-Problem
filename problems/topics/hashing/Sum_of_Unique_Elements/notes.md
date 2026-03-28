# Revision Notes: Sum of Unique Elements

## Core Concept
- **Unique vs Distinct**: "Unique" here refers to elements that appear **exactly once**. "Distinct" would refer to every different number in the array regardless of frequency.
- **Hashing**: Using a frequency count table is the standard way to identify elements with a specific frequency (in this case, frequency = 1).

## Implementation Tips
1. `Map.getOrDefault(key, 0) + 1` is an idiomatic way to increment counts in a Java HashMap.
2. If memory or speed is critical and the input range is small ($nums[i] \in [1, 100]$), prefer an `int[101]` array over a `HashMap`.

## Optimized Logic (Frequency Array)
```java
int[] counts = new int[101];
for (int n : nums) counts[n]++;
int res = 0;
for (int i = 1; i <= 100; i++) {
    if (counts[i] == 1) res += i;
}
```

## Key Insights
- Always check the constraints! Small range constraints often hint at frequency arrays as an alternative to HashMaps.
- This problem is effectively an $O(N)$ identification task once the counts are gathered.

## Complexity
- **Time**: $O(N)$
- **Space**: $O(N)$ (HashMap) or $O(1)$ (Fixed-size frequency array).
