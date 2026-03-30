# 206. Reverse Linked List

[LeetCode Problem Link](https://leetcode.com/problems/reverse-linked-list/)

## Description

Given the `head` of a singly linked list, reverse the list, and return *the reversed list*.

## Examples

**Example 1:**
![Example 1](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg)
```
Input: head = [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]
```

**Example 2:**
![Example 2](https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg)
```
Input: head = [1, 2]
Output: [2, 1]
```

**Example 3:**
```
Input: head = []
Output: []
```

## Constraints

- The number of nodes in the list is in the range `[0, 5000]`.
- `-5000 <= Node.val <= 5000`

---

## Approach 1: Iterative (Three Pointers)

The iterative approach uses three pointers to reverse the linked list in place.

### Intuition
1. Start with `prev` as `null` and `curr` as `head`.
2. As we traverse, save `curr.next` in a temporary variable `nextTemp`.
3. Change `curr.next` to point to `prev`.
4. Move `prev` to `curr` and `curr` to `nextTemp`.
5. Repeat until `curr` is `null`.
6. Return `prev` as the new head.

### Complexity Analysis
- **Time Complexity:** $O(N)$, where $N$ is the number of nodes. We traverse the list once.
- **Space Complexity:** $O(1)$. We only use a few constant pointers.

---

## Approach 2: Recursive

We can also reverse the list recursively by reaching the end and reversing the pointers as the recursion unwinds.

### Intuition
1. Base case: If `head` is `null` or `head.next` is `null`, return `head` (it's the new root).
2. Recursive step: Let `newHead` be the result of `reverseList(head.next)`.
3. To reverse current node: `head.next.next = head`.
4. Set `head.next = null`.
5. Return `newHead`.

### Complexity Analysis
- **Time Complexity:** $O(N)$.
- **Space Complexity:** $O(N)$ due to the recursion stack.

---

## Code (Java - Iterative)

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev;          
            prev = curr;               
            curr = next;
        }

        return prev;
    }
}
```
