import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 1, 1, 1 };
        System.out.println("Test Case 1: " + (solution.subarraySum(nums1, 2) == 2 ? "Passed" : "Failed")); // Expected:
                                                                                                           // 2

        // Test Case 2
        int[] nums2 = { 1, 2, 3 };
        System.out.println("Test Case 2: " + (solution.subarraySum(nums2, 3) == 2 ? "Passed" : "Failed")); // Expected:
                                                                                                           // 2
    }
}
