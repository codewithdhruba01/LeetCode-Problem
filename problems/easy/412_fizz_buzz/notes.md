# Revision Notes: Fizz Buzz

## Core Concept
- **Divisibility Rules**: Uses the modulo operator `%` to check for multiples.
- **Concatenation Pattern**: Instead of checking `if (3 && 5)`, then `if (3)`, then `if (5)`, just check `3` and `5` independently and append strings. This is cleaner and more extensible.

## Algorithm Logic
```java
String s = "";
if (i % 3 == 0) s += "Fizz";
if (i % 5 == 0) s += "Buzz";
if (s.isEmpty()) s = String.valueOf(i);
```

## Why this approach?
- **Avoids Duplication**: You don't have to write "FizzBuzz" explicitly in your code (which avoids errors if the words change).
- **Scalability**: If you need to add "Jazz" for multiples of 7, you just add one more `if` statement.

## Common Pitfalls
- **1-based Indexing**: The problem asks for values from `1` to `n`, but arrays/lists are `0-indexed`. Start your loop at `1`.
- **Performance**: While `String +=` is fine for small `n`, using `StringBuilder` or pre-allocating the `ArrayList` capacity can be slightly better for very large `n`.

## Complexity
- **Time Complexity**: `O(N)` — Linear scan from 1 to N.
- **Space Complexity**: `O(1)` — No auxiliary space used beyond the result list itself.
