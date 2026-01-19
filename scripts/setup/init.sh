#!/bin/bash

# LeetCode Environment Setup Script

echo "🚀 Setting up LeetCode Problem Solving Environment"

# Check if git is initialized
if [ ! -d ".git" ]; then
    echo "📝 Initializing Git repository..."
    git init
    git add .
    git commit -m "Initial commit: LeetCode problem solving setup"
fi

# Create .gitignore if it doesn't exist
if [ ! -f ".gitignore" ]; then
    echo "📝 Creating .gitignore..."
    cat > .gitignore << EOF
# OS generated files
.DS_Store
.DS_Store?
._*
.Spotlight-V100
.Trashes
ehthumbs.db
Thumbs.db

# IDE files
.vscode/
.idea/
*.swp
*.swo

# Python
__pycache__/
*.py[cod]
*$py.class
*.so
.Python
env/
venv/
ENV/
env.bak/
venv.bak/

# C++
*.o
*.exe
*.out
build/
cmake-build-*/

# Java
*.class
*.jar
*.war
*.ear
hs_err_pid*

# Node.js
node_modules/
npm-debug.log*
yarn-debug.log*
yarn-error.log*

# Logs
logs
*.log

# Temporary files
*.tmp
*.temp
EOF
fi

# Make scripts executable
echo "🔧 Making scripts executable..."
chmod +x scripts/generate/new_problem.sh
chmod +x scripts/setup/init.sh

echo "✅ Setup complete!"
echo ""
echo "🎯 Quick Start:"
echo "  Create a new problem: ./scripts/generate/new_problem.sh 1 two_sum easy python"
echo "  View folder structure: tree problems/"
echo "  Start coding! 🚀"