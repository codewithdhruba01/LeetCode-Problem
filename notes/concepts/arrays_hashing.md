# Arrays and Hashing

Arrays and Hashing are fundamental building blocks for many LeetCode problems.

## Arrays
An array is a collection of elements stored at contiguous memory locations.
- **Time Complexity**:
    - Access: O(1)
    - Search: O(n)
    - Insertion/Deletion: O(n)

## Hashing (Hash Maps / Sets)
Hashing is a technique used to map data of arbitrary size to data of a fixed size.
- **Why use it?**: It allows for O(1) average time complexity for lookups, insertions, and deletions.
- **Common Use Case**: Finding if an element exists in a collection (e.g., Two Sum).

### Example: [Two Sum](file:///home/dhrubaraj-pati/Desktop/LeetCode-problem/problems/easy/1_two_sum)
Instead of a nested loop (O(n²)), use a Hash Map to store the difference between the target and the current number (O(n)).
