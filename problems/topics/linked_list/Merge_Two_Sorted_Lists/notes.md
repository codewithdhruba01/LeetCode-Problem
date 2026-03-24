# Revision Notes: Merge Two Sorted Lists

## Core Concept
- **Pointer Manipulation**: Merging sorted linked lists is all about comparing the current heads and updating the `next` pointer of the result list.
- **Dummy Node Pattern**: Always use a dummy node when building a new linked list. It eliminates the need for special "first node" logic (where you have to check if the head is null).

## Algorithm Logic
1. Start with `dummy = new ListNode(-1)` and `current = dummy`.
2. Compare `list1.val` and `list2.val`.
3. Point `current.next` to the smaller one and advance that list's pointer.
4. Advance `current`.
5. Repeat until one list is exhausted.
6. Attach the leftovers: `current.next = (list1 != null) ? list1 : list2`.

## Key Insights
- **O(1) Space**: We are not creating a *new* list in terms of memory used for nodes. We are simply changing the `next` pointers of existing nodes from `list1` and `list2`.
- **Leftover Check**: Since the lists are sorted, once one ends, the remaining elements of the other list are guaranteed to be greater than all elements currently in the merged list. We can attach the whole remaining block in one assignment.

## Complexity
- **Time**: $O(N + M)$ - We visit each node in both lists.
- **Space**: $O(1)$ - Excluding the nodes themselves, we only use a few constant pointers.
