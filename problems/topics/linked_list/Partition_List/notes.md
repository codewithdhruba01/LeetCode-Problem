# Revision Notes: Partition List

## Core Concept
- **Maintain Relative Order**: Each partition should keep its original sequence. This rules out simple swaps and suggests building new lists while iterating.
- **Two-List Strategy**: Construct two separate lists simultaneously and join them at the end.

## Key Logic
1. **Dummy Nodes**: Use `smallDummy` and `largeDummy` to simplify edge cases (like when one partition is empty).
2. **Current Pointers**: Use `small` and `large` pointers to build the lists.
3. **Termination**: `large.next = null` is **critical**. Without it, if the last node of the original list happens to be in the "small" partition, the "large" partition's tail might still point to a node that now precedes it in the final list, creating a cycle.

## Complexity
- **Time**: $O(N)$ - Single pass through the list.
- **Space**: $O(1)$ - We only use four extra pointer variables; no new nodes are created (except the two dummies).

## Common Mistakes
- **Forgetting `large.next = null`**: Leads to infinite loops in the resulting list.
- **Lost Head**: Always return `smallDummy.next` as `smallDummy` itself is just a placeholder.
