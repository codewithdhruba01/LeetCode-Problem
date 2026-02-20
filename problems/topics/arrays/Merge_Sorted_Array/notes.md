# Revision Notes: Merge Sorted Array

## Core Concept
-   **Merge from End**: The trick to `O(1)` space in-place merging is to **start filling from the back** of `nums1`. This avoids overwriting elements we still need.
-   **Three Pointers**: `i` (end of nums1's valid part), `j` (end of nums2), `k` (end of total array).

## Algorithm Logic
```java
int i = m - 1, j = n - 1, k = m + n - 1;
while (i >= 0 && j >= 0) {
    if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
    else                      nums1[k--] = nums2[j--];
}
// Only need to handle remaining nums2 elements
while (j >= 0) nums1[k--] = nums2[j--];
```

## Common Pitfalls
-   **Leftover nums2 elements**: After the main loop, if `j >= 0`, we must copy remaining `nums2` elements.
-   **Leftover nums1 elements**: If `i >= 0` after the main loop, do nothing — those elements are already in the correct positions in `nums1`.
-   **Merging from the front**: Naive approach of merging from the front requires a temporary extra array or shifting, making it `O(m*n)` or `O(m+n)` space.

## Complexity
-   **Time**: `O(m + n)` - Single pass from end to start.
-   **Space**: `O(1)` - Pure in-place.
