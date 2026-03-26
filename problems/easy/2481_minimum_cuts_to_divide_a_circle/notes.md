# Revision Notes: Minimum Cuts to Divide a Circle

## Core Concept
- **Diameter vs Radius**: A cut through the center (diameter) is basically two radius cuts joined together.
- **Symmetry**: 
  - Even $n$ allows us to pair up slices across the center.
  - Odd $n$ does not allow pairing; every "slice" essentially needs its own cut boundary from the center.

## Decision Logic
1. `n == 1` $\implies$ `0` (No work needed).
2. `n % 2 == 0` $\implies$ `n / 2` (Diameters).
3. `n % 2 != 0` $\implies$ `n` (Radii).

## Key Takeaway
- Always look for mathematical patterns or parity-based simplifications in "Minimum X" geometry problems before jumping into simulations or complex logic.
- The `n=1` case is a classic "trap" edge case in such problems.

## Complexity
- **Time**: $O(1)$.
- **Space**: $O(1)$.
