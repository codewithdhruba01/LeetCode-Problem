# Notes - Palindrome Number

## Key Takeaways
- **Efficiency**: Reversing only half of the number is more efficient than converting it to a string or reversing the entire number.
- **Overflow Prevention**: Reversing only half also inherently prevents integer overflow issues that might occur if the full reversed number exceeds the 32-bit integer limit.
- **Edge Cases**: Always consider negative numbers and numbers ending in zero early.

## Common Pitfalls
- Forgetting the special case where a number ends in zero (e.g., `10`, `100`).
- Not handling the middle digit correctly during the comparison for odd-length numbers.
