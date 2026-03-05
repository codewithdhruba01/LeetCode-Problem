# Revision Notes: Count Primes

## Core Concept
- **Efficiency**: Trial division `O(N * sqrt(N))` is too slow for `N = 5 * 10^6`. The **Sieve of Eratosthenes** is the required optimization.
- **Prime Definition**: Primes are numbers greater than 1 that have no divisors other than 1 and themselves.

## Algorithm Logic (Sieve)
1. Initialize a boolean array of size `n` with `true`.
2. Iterate `i` from `2` up to `sqrt(n)`.
3. If `isPrime[i]` is still `true`:
   - It's a prime.
   - Mark all its multiples `i*i, i*(i+1), ...` as `false`.
4. Starting at `i*i` instead of `2*i` is a key optimization (smaller multiples were already marked by smaller primes).

## Key Insights
- **Outer Loop Bound**: We only need to sieve up to `sqrt(n)` because any composite number `c < n` must have at least one factor `f <= sqrt(c) <= sqrt(n)`.
- **Inner Loop Start**: Starting at `i * i` avoids redundant work (e.g., for `i=5`, `2*5`, `3*5`, and `4*5` were already marked by `2`, `3`, and `2` respectively).

## Complexity
- **Time Complexity**: `O(N log log N)` — Hard to derive but effectively near-linear for practical ranges.
- **Space Complexity**: `O(N)` — Required for the boolean array.

## Common Pitfalls
- **Off-by-one**: The problem asks for primes *strictly less than* `n`, so use index `< n`.
- **Large N**: For `N = 5 * 10^6`, ensure the array size is handled correctly (boolean uses less memory than int).
