# Notes - Add Two Numbers

## Key Takeaways
- Using a **dummy node** is a very common and effective pattern for linked list problems to avoid edge cases related to the head of the list.
- Addition problems with carries are straightforward but need careful handling of the final carry if it exists after both lists are exhausted.
- The "reverse order" storage actually makes the addition easier as we start from the least significant digit (LSD), which is how we naturally add numbers.

## Common Pitfalls
- Forgetting to handle the final carry at the end of the loop.
- Not checking for `null` before accessing `node.val` or `node.next`.
