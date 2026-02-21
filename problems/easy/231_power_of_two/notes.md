# Revision Notes: Power of Two

## Core Concept
- **Binary Representation**: A power of two (1, 2, 4, 8, ...) always has exactly one '1' bit in its binary form:
    - 1: `0001`
    - 2: `0010`
    - 4: `0100`
    - 8: `1000`

## The Bit Trick: `n & (n - 1)`
- Subtracting 1 from a number flips the lowest set bit and all bits to its right.
- For a power of two, there is only ONE set bit.
- Subtracting 1 flips that one bit to 0 and all trailing zeros to 1.
- `n & (n - 1)` will then result in 0.
- **Example (n=8)**:
    - `n`     = `1000`
    - `n-1`   = `0111`
    - `n&(n-1)`= `0000`

## Edge Cases
- **n <= 0**: Negative numbers and zero are NOT powers of two.
- **Integer Overflow**: Be careful if using loops or recursion; however, the bit manipulation approach handles the entire `int` range safely.

## Alternatives
- **Iterative**: Keep dividing by 2 while the remainder is 0. If it ends at 1, it's a power of two.
- **Math**: Check if `log2(n)` is an integer. Or check if `2^30 % n == 0` (since `2^30` is the largest power of two that fits in a signed 32-bit integer).
