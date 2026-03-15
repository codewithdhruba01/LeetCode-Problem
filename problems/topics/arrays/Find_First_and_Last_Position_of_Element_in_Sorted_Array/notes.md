# Revision Notes: Find First and Last Position in Sorted Array

## Core Concept
- **Boundary Search**: Standard binary search stops when `arr[mid] == target`. To find boundaries (first/last), we must *not* stop when we find the target. Instead, we record the position and continue searching in the appropriate half.

## Algorithm Logic
We need two separate helper functions, though their structure is almost identical:

**1. Finding the First Occurrence (`findFirst`)**
- When `nums[mid] == target`, it might be the first one, or there might be others to its left.
- Action: Save `mid`, then search the left half: `right = mid - 1`.

**2. Finding the Last Occurrence (`findLast`)**
- When `nums[mid] == target`, it might be the last one, or there might be others to its right.
- Action: Save `mid`, then search the right half: `left = mid + 1`.

## Key Insights
- **Decoupling**: It's much cleaner and less error-prone to write two independent `$O(\log N)$` binary searches rather than trying to expand outwards from a single found `mid`. Expanding outwards would degrade to $O(N)$ time if the array is full of the target (e.g., `[8,8,8,8,8]`).
- **Initialization**: Initialize answers to `-1` so that if the element is never found, it defaults to the required `[-1, -1]`.

## Complexity
- **Time Complexity**: $O(\log N)$ + $O(\log N)$ = $O(\log N)$.
- **Space Complexity**: $O(1)$ for iterative binary search.
