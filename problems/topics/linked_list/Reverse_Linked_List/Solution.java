/**
 * 206. Reverse Linked List
 * 
 * Approach: Iterative (Three Pointers)
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // Temporary store next node
            curr.next = prev;          // Reverse the current node's pointer
            prev = curr;               // Move prev and curr one step forward
            curr = next;
        }

        return prev; // New head of the reversed list
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: [1, 2, 3, 4, 5]
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original: ");
        printList(head);
        ListNode reversed = solution.reverseList(head);
        System.out.print("Reversed: ");
        printList(reversed);

        // Test Case 2: [1, 2]
        head = createList(new int[]{1, 2});
        System.out.print("\nOriginal: ");
        printList(head);
        reversed = solution.reverseList(head);
        System.out.print("Reversed: ");
        printList(reversed);

        // Test Case 3: []
        head = createList(new int[]{});
        System.out.print("\nOriginal: ");
        printList(head);
        reversed = solution.reverseList(head);
        System.out.print("Reversed: ");
        printList(reversed);
    }

    private static ListNode createList(int[] vals) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : vals) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}
