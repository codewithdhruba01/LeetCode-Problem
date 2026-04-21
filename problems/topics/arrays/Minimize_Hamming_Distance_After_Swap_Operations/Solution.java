import java.util.*;

/**
 * 1722. Minimize Hamming Distance After Swap Operations
 * 
 * Approach: Disjoint Set Union (DSU) + Frequency Map
 * Time Complexity: O(N + S * alpha(N)), where S is number of swaps
 * Space Complexity: O(N)
 */

class Solution {
    class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                parent[rootA] = rootB;
            }
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);

        // Step 1: Build components from allowed swaps
        // Indices in the same component can be rearranged in any order
        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }

        // Step 2: Group source values by their component's root
        Map<Integer, Map<Integer, Integer>> componentFrequencies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            componentFrequencies.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> freqMap = componentFrequencies.get(root);
            freqMap.put(source[i], freqMap.getOrDefault(source[i], 0) + 1);
        }

        // Step 3: Calculate Hamming Distance
        // For each index, check if target[i] exists in its component's source values
        int hammingDistance = 0;
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            int targetVal = target[i];
            Map<Integer, Integer> freqMap = componentFrequencies.get(root);

            if (freqMap.getOrDefault(targetVal, 0) > 0) {
                // If it exists, we can move it here, so it matches
                freqMap.put(targetVal, freqMap.get(targetVal) - 1);
            } else {
                // If it doesn't exist, this position contributes to Hamming Distance
                hammingDistance++;
            }
        }

        return hammingDistance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] source1 = {1, 2, 3, 4};
        int[] target1 = {2, 1, 4, 5};
        int[][] swaps1 = {{0, 1}, {2, 3}};
        System.out.println("Test Case 1 Output: " + solution.minimumHammingDistance(source1, target1, swaps1)); // Expected: 1

        // Test Case 2
        int[] source2 = {1, 2, 3, 4};
        int[] target2 = {1, 3, 2, 4};
        int[][] swaps2 = {};
        System.out.println("Test Case 2 Output: " + solution.minimumHammingDistance(source2, target2, swaps2)); // Expected: 2

        // Test Case 3
        int[] source3 = {5, 1, 2, 4, 3};
        int[] target3 = {1, 5, 4, 2, 3};
        int[][] swaps3 = {{0, 4}, {4, 2}, {1, 3}, {1, 4}};
        System.out.println("Test Case 3 Output: " + solution.minimumHammingDistance(source3, target3, swaps3)); // Expected: 0
    }
}
