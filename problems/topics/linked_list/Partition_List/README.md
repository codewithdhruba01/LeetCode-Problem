# 86. Partition List

[LeetCode Problem Link](https://leetcode.com/problems/partition-list/)

## Description

Given the `head` of a linked list and a value `x`, partition it such that all nodes **less than** `x` come before nodes **greater than or equal to** `x`.

You should **preserve** the original relative order of the nodes in each of the two partitions.

## Examples

**Example 1:**
![Partition List Example](https://assets.leetcode.com/uploads/2021/01/04/partition.jpg)
```
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
```

**Example 2:**
```
Input: head = [2,1], x = 2
Output: [1,2]
```

## Constraints

- The number of nodes in the list is in the range `[0, 200]`.
- `-100 <= Node.val <= 100`
- `-200 <= x <= 200`

## Approach: Two-Pointer (Two-List Construction)

The most efficient way to solve this while preserving relative order is to maintain two separate lists and then join them.

### Intuition

1. **Two Lists**: We create two dummy nodes:
    - `smallDummy`: To start a list of nodes with values **less than** `x`.
    - `largeDummy`: To start a list of nodes with values **greater than or equal to** `x`.
2. **Iteration**: Traverse the original list.
    - If `head.val < x`, append the node to the `small` list.
    - Otherwise, append it to the `large` list.
3. **Connection**: 
    - Terminate the `large` list with `null` (very important to avoid cycles).
    - Connect the end of the `small` list to the beginning of the `large` list (`largeDummy.next`).
4. **Result**: Return `smallDummy.next` as the new head.

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the number of nodes in the linked list. We traverse the list exactly once.
- **Space Complexity:** $O(1)$, as we only rearrange existing nodes using pointers.

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
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        
        ListNode small = smallDummy;
        ListNode large = largeDummy;
        
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        
        // Important: end large list to avoid cycles
        large.next = null;
        
        // Connect both lists
        small.next = largeDummy.next;
        
        return smallDummy.next;
    }
}
```
