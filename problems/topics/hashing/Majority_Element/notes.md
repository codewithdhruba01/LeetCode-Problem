# Revision Notes: Majority Element

## Core Concept
- **Majority Requirement**: The majority element must appear strictly more than `n / 2` times.
- **Cancellation Property**: If we treat the majority element as `+1` and every other element as `-1`, the net sum will definitely be positive.

## Boyer-Moore Voting Algorithm Logic
1. Maintains a `candidate` and a `count`.
2. When `count == 0`, the current element becomes the `candidate`.
3. If the next element matches the `candidate`, increment `count`.
4. If it doesn't match, decrement `count`.
5. At the end of the pass, the `candidate` is the majority element.

## Key Insights
- **Why it works**: Even if all non-majority elements combine together, they cannot "vote out" the majority element because the majority element has more than $n/2$ votes.
- **Assumption**: This algorithm assumes a majority element *exists*. If it's not guaranteed, you would need a second pass to verify that the final candidate actually appears more than $n/2$ times.

## Complexity
- **Time**: $O(N)$ - Single pass.
- **Space**: $O(1)$ - Only two extra variables, regardless of input size. 
  - Compare this to Hashing which takes $O(N)$ extra space.
