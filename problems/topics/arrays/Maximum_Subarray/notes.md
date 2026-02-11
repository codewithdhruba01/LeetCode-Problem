## Problem Summary

You are given an integer array.
You need to find the **continuous subarray** that has the maximum sum and return that sum.


## Approach Used: Kadane’s Algorithm

### Idea

At every index, we have two choices:

1. Continue the previous subarray
2. Start a new subarray from the current element

> We choose whichever gives the larger sum.


## Algorithm Logic

Initialize:

```
currentSum = nums[0]
maxSum = nums[0]
```

Then iterate through the array:

```
currentSum = max(nums[i], currentSum + nums[i])
maxSum = max(maxSum, currentSum)
```

## Intuition

If the running sum becomes negative,
it is useless to carry it forward.

So we start a new subarray from that point.


## Time & Space Complexity

* Time Complexity  : O(n)
* Space Complexity : O(1)

* Only one traversal
* No extra space used


## Key Points

* This is a mix of Greedy and Dynamic Programming concepts
* We maintain a local maximum at each step
* The final answer is the global maximum
* This is the most optimal solution for this problem
