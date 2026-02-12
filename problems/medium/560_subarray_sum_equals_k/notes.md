# Revision Notes: Subarray Sum Equals K

## Core Concept
-   **Prefix Sum + HashMap**: Store cumulative sums and their frequencies.
-   **Key Insight**: If `sum - k` exists in the map, there's a subarray ending at the current index with sum `k`.

## Algorithm Logic
```java
HashMap<Integer, Integer> map = new HashMap<>();
map.put(0, 1); // Base case: empty prefix

int sum = 0, count = 0;

for (int num : nums) {
    sum += num;
    if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
    }
    map.put(sum, map.getOrDefault(sum, 0) + 1);
}
```

## Common Pitfalls
-   Forgetting to initialize the map with `{0: 1}`. This handles cases where the prefix sum itself equals `k`.
-   Updating the map **after** checking for `sum - k` (correct order matters).

## Complexity
-   **Time**: `O(n)` - Single pass through the array.
-   **Space**: `O(n)` - HashMap can store up to `n` unique prefix sums.

## Key Points
-   This is a classic **prefix sum** problem.
-   HashMap allows `O(1)` lookup for `sum - k`.
-   Can handle negative numbers and duplicate sums.

## Alternative Approaches
-   **Brute Force**: Check all subarrays. `O(n^2)` or `O(n^3)`. Too slow.
-   **Cumulative Sum Array**: Similar idea but less efficient without HashMap.
