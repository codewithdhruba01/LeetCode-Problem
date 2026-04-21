# 1722. Minimize Hamming Distance After Swap Operations

[LeetCode Problem Link](https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/)

## Description

You are given two integer arrays, `source` and `target`, both of length `n`. You are also given an array `allowedSwaps` where each `allowedSwaps[i] = [ai, bi]` indicates that you are allowed to swap the elements at index `ai` and index `bi` (0-indexed) of array `source`. Note that you can swap elements at a specific pair of indices multiple times and in any order.

The **Hamming distance** of two arrays of the same length, `source` and `target`, is the number of positions where the elements are different. Formally, it is the number of indices `i` for `0 <= i <= n-1` where `source[i] != target[i]` (0-indexed).

Return *the **minimum Hamming distance** of `source` and `target` after performing any amount of swap operations on array `source`*.

## Examples

**Example 1:**
```
Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
Output: 1
Explanation: source can be transformed the following way:
- Swap indices 0 and 1: source = [2,1,3,4]
- Swap indices 2 and 3: source = [2,1,4,3]
The Hamming distance of source and target is 1 as they differ in 1 position: index 3.
```

**Example 2:**
```
Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
Output: 2
Explanation: There are no allowed swaps.
The Hamming distance of source and target is 2 as they differ in 2 positions: index 1 and index 2.
```

**Example 3:**
```
Input: source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
Output: 0
```

## Constraints

- `n == source.length == target.length`
- `1 <= n <= 10^5`
- `1 <= source[i], target[i] <= 10^5`
- `0 <= allowedSwaps.length <= 10^5`
- `allowedSwaps[i].length == 2`
- `0 <= ai, bi <= n - 1`
- `ai != bi`

---

## Approach: Disjoint Set Union (DSU)

The key insight is that if index $A$ can be swapped with $B$, and $B$ can be swapped with $C$, then elements at $A, B, \text{ and } C$ can be rearranged into **any permutation** among those three indices.

### Intuition
1. **Connectivity**: The `allowedSwaps` define a graph where indices are nodes and swaps are edges. Any indices in the same **connected component** can swap their elements freely.
2. **DSU**: Use Disjoint Set Union to find all connected components of indices.
3. **Freedom within Components**: For each component, we have a set of values from `source` and a set of values from `target` at those same indices. To minimize Hamming distance, we want to match as many values as possible between `source` and `target` within that component.
4. **Matching**: For each component, count the frequencies of values in `source`. Then, for each value in `target` at those indices, check if it exists in the `source` frequency map. If it does, we can "place" it at that index to match.

### Complexity Analysis
- **Time Complexity:** $O((N + S) \alpha(N))$, where $N$ is the number of elements and $S$ is the number of swaps. $\alpha$ is the inverse Ackermann function.
- **Space Complexity:** $O(N)$ for the recursion/parent array and frequency maps.

---

## Code (Java)

```java
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);
        for (int[] swap : allowedSwaps) dsu.union(swap[0], swap[1]);

        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            groups.computeIfAbsent(root, k -> new HashMap<>())
                  .merge(source[i], 1, Integer::sum);
        }

        int distance = 0;
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            Map<Integer, Integer> map = groups.get(root);
            if (map.getOrDefault(target[i], 0) > 0) {
                map.put(target[i], map.get(target[i]) - 1);
            } else {
                distance++;
            }
        }
        return distance;
    }
}
```
