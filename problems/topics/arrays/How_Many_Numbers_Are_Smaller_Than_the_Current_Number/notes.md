# Revision Notes: How Many Numbers Are Smaller Than the Current Number

## Core Concept
- When the possible *range of values* is significantly smaller than the *number of elements* (or simply very small integers like `[0, 100]`), **array-based hashing (Frequency Arrays / Counting Sort techniques)** are usually the most optimal approach.

## Algorithm Logic
1. **Frequency Array**: Create an array `count` of size `101` (to cover indices `0` to `100`). Count occurrences of each number in `nums`.
2. **Prefix Sum**: Modify `count` in place such that `count[i] = count[i] + count[i-1]`. Now `count[i]` answers the question: "How many numbers are $\le i$?".
3. **Lookup**: Iterate the original `nums` array. To find how many numbers are *strictly less* than `nums[i]`, we simply look at `count[nums[i] - 1]`. For `nums[i] == 0`, the answer is obviously `0` (prevents `IndexOutOfBoundsException`).

## Why not Sorting?
- A sorting approach involves creating a copy of the array, sorting it ($O(N \log N)$), and then using a HashMap or binary search to find the first occurrence of each element.
- The frequency array approach avoids sorting overhead and works in true $O(N)$ linear time since the prefix sum loop is a constant $100$ iterations.

## Complexity
- **Time Complexity**: $O(N)$, where $N$ is `nums.length`. The prefix sum loop runs exactly $100$ times, which is $O(1)$.
- **Space Complexity**: $O(1)$ extra space. The `count` array is always size `101`, regardless of the input size $N$.
