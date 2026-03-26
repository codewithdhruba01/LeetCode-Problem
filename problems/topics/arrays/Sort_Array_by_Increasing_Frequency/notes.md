# Revision Notes: Sort Array by Increasing Frequency

## Core Concept
- **Frequency-Based Sorting**: This is a very common interview pattern. It requires a two-step process: counting (hashing) and then sorting with a custom comparator.
- **Tie-Breaking**: The problem specifically asks for a decreasing value sort if frequencies match. This is the "secondary" sort key.

## Key Logic
1. `Map<Integer, Integer> freq = new HashMap<>();`
2. Boxing: `Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);` (or a manual loop for simplicity/performance in interviews).
3. Sorting:
   ```java
   Arrays.sort(arr, (a, b) -> {
       if (freq.get(a) == freq.get(b)) return b - a; // Value DESC
       return freq.get(a) - freq.get(b); // Frequency ASC
   });
   ```

## Key Insights
- **Primitives vs Objects**: Remember that `Arrays.sort(int[])` uses Dual-Pivot Quicksort and doesn't take a comparator. You *must* work with `Integer[]` or a `List<Integer>` to use custom sorting.
- **Boxed Comparision**: When using `.equals()` or `==` on Map results, be careful. `freq.get(a).equals(freq.get(b))` is safer if you aren't unboxing to `int` first.

## Complexity
- **Time**: $O(N \log N)$ due to sorting.
- **Space**: $O(N)$ for the Frequency Map and the auxiliary boxed array.
