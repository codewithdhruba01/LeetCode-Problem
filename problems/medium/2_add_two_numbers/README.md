# 2. Add Two Numbers

## Problem Description

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### Example 1:
**Input:** `l1 = [2,4,3], l2 = [5,6,4]`  
**Output:** `[7,0,8]`  
**Explanation:** `342 + 465 = 807.`

### Example 2:
**Input:** `l1 = [0], l2 = [0]`  
**Output:** `[0]`

### Example 3:
**Input:** `l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]`  
**Output:** `[8,9,9,9,0,0,0,1]`

---

## Approach

We can traverse both linked lists simultaneously and simulated the addition process. 

1. Initialize a `dummy` node to act as the head of the result list.
2. Maintain a `carry` variable (initially 0).
3. Loop through the lists as long as there is an element in either list or a non-zero carry.
4. In each step:
   - Calculate the sum: `val1 + val2 + carry`.
   - Update `carry`: `sum / 10`.
   - Create a new node with `sum % 10` and attach it to the result list.
   - Move the pointers forward.
5. Return `dummy.next`.

## Complexity Analysis

- **Time Complexity:** $O(\max(N, M))$, where $N$ and $M$ are the lengths of the two linked lists. We traverse each node once.
- **Space Complexity:** $O(\max(N, M))$ (for the output list). If we don't count the output list, it's $O(1)$.

---

## LeetCode Link
[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
