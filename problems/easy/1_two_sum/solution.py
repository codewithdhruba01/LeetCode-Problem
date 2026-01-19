"""
LeetCode Problem: Two Sum

Problem Number: 1
Problem Name: Two Sum
Difficulty: Easy
Topics: Array, Hash Table

Time Complexity: O(n)
Space Complexity: O(n)

Approach: Use hash map to store seen numbers and check for complement
"""

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        Find two numbers in the array that add up to target.

        Args:
            nums: List of integers
            target: Target sum

        Returns:
            List of indices of two numbers that add up to target
        """
        num_map = {}
        for i, num in enumerate(nums):
            complement = target - num
            if complement in num_map:
                return [num_map[complement], i]
            num_map[num] = i
        return []

# Test cases
def test_solution():
    solution = Solution()

    # Test case 1
    nums1 = [2, 7, 11, 15]
    target1 = 9
    result1 = solution.twoSum(nums1, target1)
    expected1 = [0, 1]
    assert result1 == expected1, f"Test 1 failed: expected {expected1}, got {result1}"

    # Test case 2
    nums2 = [3, 2, 4]
    target2 = 6
    result2 = solution.twoSum(nums2, target2)
    expected2 = [1, 2]
    assert result2 == expected2, f"Test 2 failed: expected {expected2}, got {result2}"

    # Test case 3
    nums3 = [3, 3]
    target3 = 6
    result3 = solution.twoSum(nums3, target3)
    expected3 = [0, 1]
    assert result3 == expected3, f"Test 3 failed: expected {expected3}, got {result3}"

    print("All tests passed! ✅")

if __name__ == "__main__":
    test_solution()