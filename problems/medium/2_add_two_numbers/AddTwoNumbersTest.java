
/**
 * LeetCode Problem: Add Two Numbers
 *
 * Problem Number: 2
 * Problem Name: Add Two Numbers
 * Difficulty: Medium
 * Topics: Linked List, Math, Recursion
 */

// Inheriting definitions from Solution.java is not possible if they are not
// public/in same package
// In this repo, it seems they repeat the code in the test file.

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return dummy.next;
    }
}

public class AddTwoNumbersTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        ListNode l1_1 = createList(new int[] { 2, 4, 3 });
        ListNode l1_2 = createList(new int[] { 5, 6, 4 });
        ListNode res1 = solution.addTwoNumbers(l1_1, l1_2);
        check(res1, new int[] { 7, 0, 8 });

        // Test case 2
        ListNode l2_1 = createList(new int[] { 0 });
        ListNode l2_2 = createList(new int[] { 0 });
        ListNode res2 = solution.addTwoNumbers(l2_1, l2_2);
        check(res2, new int[] { 0 });

        System.out.println("All tests passed!");
    }

    private static ListNode createList(int[] vals) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return head.next;
    }

    private static void check(ListNode res, int[] expected) {
        for (int v : expected) {
            if (res == null || res.val != v) {
                throw new RuntimeException("Test failed!");
            }
            res = res.next;
        }
        if (res != null)
            throw new RuntimeException("Test failed!");
    }
}
