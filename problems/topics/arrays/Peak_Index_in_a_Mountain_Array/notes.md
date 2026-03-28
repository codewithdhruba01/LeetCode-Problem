# Revision Notes: Peak Index in a Mountain Array

## Core Concept
- **Mountain Property**: The array strictly increases to a peak then strictly decreases.
- **Binary Search Applicability**: Binary search is not just for sorted arrays; it works here because the "direction" of the gradient ($arr[i] < arr[i+1]$) is monotonic until the peak.

## Why $O(\log N)$?
- Instead of checking every element ($O(N)$), we eliminate half of the elements in each step based on the comparison of $arr[mid]$ and $arr[mid+1]$.
- If $arr[mid] < arr[mid+1]$, we are on the "upward" path, so peak must be at an index $> mid$.
- If $arr[mid] > arr[mid+1]$, we are on the "downward" path, so peak must be at an index $\le mid$.

## Key Logic
1. `while (left < right)`
2. `mid = (left + right) / 2`
3. `if (arr[mid] < arr[mid+1]) left = mid + 1`
4. `else right = mid`
5. `return left`

## Complexity
- **Time**: $O(\log N)$
- **Space**: $O(1)$
