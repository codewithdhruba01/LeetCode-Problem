# Revision Notes: Contains Duplicate

## Core Concept
- **Hasing for Fast Lookup**: Using a `HashSet` allows us to check for the existence of an element in `O(1)` average time.
- **Trade-off**: We trade space (`O(N)`) for speed (`O(N)` time instead of `O(N^2)` with nested loops or `O(N log N)` with sorting).

## Alternative Approaches
1. **Sorting**:
   - Sort the array first: `Arrays.sort(nums)`.
   - Check adjacent elements: `if (nums[i] == nums[i+1]) return true`.
   - **Time**: `O(N log N)`, **Space**: `O(1)` (excluding sorting overhead).
2. **Brute Force**:
   - Nested loops to compare every pair.
   - **Time**: `O(N^2)`, **Space**: `O(1)`.

## Algorithm Logic (HashSet)
1. Initialize `HashSet<Integer> set`.
2. For each `num` in `nums`:
   - If `set.contains(num)`, return `true`.
   - `set.add(num)`.
3. Return `false`.

## Key Insights
- **Early Exit**: We return `true` as soon as the first duplicate is found.
- **Constraints**: With `N` up to `10^5`, an `O(N^2)` solution will likely TLE. `O(N)` or `O(N log N)` are required.

## Complexity
- **Time Complexity**: `O(N)`.
- **Space Complexity**: `O(N)`.
