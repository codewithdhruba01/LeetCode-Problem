/**
 * 204. Count Primes
 * 
 * Approach: Sieve of Eratosthenes
 * Time Complexity: O(N log log N)
 * Space Complexity: O(N)
 */
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        // isPrime[i] will be true if i is a prime number
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // If i is prime, mark all its multiples starting from i*i
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count the remaining true values
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Input: 10, Output: " + solution.countPrimes(10)); // Expected: 4 (2, 3, 5, 7)

        // Test Case 2
        System.out.println("Input: 0, Output: " + solution.countPrimes(0)); // Expected: 0

        // Test Case 3
        System.out.println("Input: 1, Output: " + solution.countPrimes(1)); // Expected: 0

        // Test Case 4
        System.out.println("Input: 499979, Output: " + solution.countPrimes(499979)); // large input test
    }
}
