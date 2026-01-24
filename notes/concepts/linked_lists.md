# Linked Lists

A linked list is a linear data structure where elements are not stored in contiguous memory. Each element (node) contains a value and a pointer to the next node.

## Types
- **Singly Linked List**: Each node points to the next node.
- **Doubly Linked List**: Each node points to both the next and previous nodes.

## Common Techniques
- **Dummy Headers**: Useful for simplifying edge cases (e.g., adding or removing nodes from the head).
- **Two Pointers (Fast/Slow)**: Used for finding cycles or the middle of the list.

### Example: [Add Two Numbers](file:///home/dhrubaraj-pati/Desktop/LeetCode-problem/problems/medium/2_add_two_numbers)
Iterate through both lists, keeping track of the carry-over at each step.
