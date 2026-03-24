# 21. Merge Two Sorted Lists

[LeetCode Problem Link](https://leetcode.com/problems/merge-two-sorted-lists/)

## Description

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return *the head of the merged linked list*.

## Examples

**Example 1:**
![Example 1](https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg)
```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

**Example 2:**
```
Input: list1 = [], list2 = []
Output: []
```

**Example 3:**
```
Input: list1 = [], list2 = [0]
Output: [0]
```

## Constraints

- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 <= Node.val <= 100`
- Both `list1` and `list2` are sorted in **non-decreasing** order.

## Approach: Iterative with Dummy Node

The most intuitive way to merge two sorted linked lists is to traverse them simultaneously and pick the smaller node at each step.

### Intuition

1. **Dummy Node**: Create a `dummy` node to act as the start of the merged list. This avoids special cases for setting the head.
2. **Current Pointer**: Use a `current` pointer to keep track of the last added node in the merged list, starting at `dummy`.
3. **Traverse**: While both `list1` and `list2` are not null:
   - Compare the values of the heads of `list1` and `list2`.
   - Append the node with the smaller value to `current.next`.
   - Move the pointer of the selected list forward.
   - Move `current` forward.
4. **Remaining Nodes**: After the loop, one list might still have nodes. Since both lists were already sorted, just append the remaining part of the non-null list to `current.next`.
5. **Return**: The actual head of the merged list is `dummy.next`.

### Complexity Analysis

- **Time Complexity:** $O(N + M)$, where $N$ and $M$ are the lengths of the two lists. We visit each node exactly once.
- **Space Complexity:** $O(1)$. We only rearrange existing nodes; we don't create new ones (except for the dummy node).

## Code (Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // Attach the remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        return dummy.next;
    }
}
```
