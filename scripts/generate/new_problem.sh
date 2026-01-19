#!/bin/bash

# LeetCode Problem Generator Script
# Usage: ./new_problem.sh <problem_number> <problem_name> <difficulty> <language>

if [ $# -lt 3 ]; then
    echo "Usage: $0 <problem_number> <problem_name> <difficulty> [language]"
    echo "Example: $0 1 two_sum easy python"
    echo "Difficulties: easy, medium, hard"
    echo "Languages: python, cpp, java, javascript (default: python)"
    exit 1
fi

PROBLEM_NUM=$1
PROBLEM_NAME=$2
DIFFICULTY=$3
LANGUAGE=${4:-python}

# Convert problem name to snake_case
PROBLEM_DIR="${PROBLEM_NUM}_$(echo $PROBLEM_NAME | tr '[:upper:]' '[:lower:]' | tr ' ' '_')"

# Create problem directory
mkdir -p "problems/$DIFFICULTY/$PROBLEM_DIR"

# Copy template based on language
case $LANGUAGE in
    python)
        cp "templates/python/solution_template.py" "problems/$DIFFICULTY/$PROBLEM_DIR/solution.py"
        ;;
    cpp)
        cp "templates/cpp/solution_template.cpp" "problems/$DIFFICULTY/$PROBLEM_DIR/solution.cpp"
        ;;
    java)
        # Add java template later
        ;;
    javascript)
        # Add js template later
        ;;
    *)
        echo "Unsupported language: $LANGUAGE"
        exit 1
        ;;
esac

# Create README for the problem
cat > "problems/$DIFFICULTY/$PROBLEM_DIR/README.md" << EOF
# Problem $PROBLEM_NUM: $PROBLEM_NAME

**Difficulty:** $DIFFICULTY

## Problem Statement

[Add problem description here]

## Examples

**Example 1:**
- Input:
- Output:
- Explanation:

## Constraints

## Approach

## Time Complexity

## Space Complexity

## Solution

\`\`\`$LANGUAGE
[Solution code here]
\`\`\`
EOF

# Create notes file
cat > "problems/$DIFFICULTY/$PROBLEM_DIR/notes.md" << EOF
# Notes for Problem $PROBLEM_NUM: $PROBLEM_NAME

## Key Learnings

## Mistakes Made

## Alternative Approaches

## Related Problems
EOF

# Create test cases file
cat > "problems/$DIFFICULTY/$PROBLEM_DIR/test_cases.txt" << EOF
# Test Cases for Problem $PROBLEM_NUM: $PROBLEM_NAME

# Test Case 1
# Input:
# Expected Output:

# Test Case 2
# Input:
# Expected Output:

# Edge Cases
EOF

echo "✅ Problem folder created: problems/$DIFFICULTY/$PROBLEM_DIR"
echo "📝 Don't forget to:"
echo "   1. Update the README.md with problem details"
echo "   2. Implement your solution in the solution file"
echo "   3. Add test cases"
echo "   4. Update notes after solving"