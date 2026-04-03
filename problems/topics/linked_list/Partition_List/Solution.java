/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 86. Partition List
 * 
 * Approach: Two-Pointer (Maintain two separate lists and join them)
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        // Important: terminate the large list to prevent cycles in the final list
        large.next = null;

        // Connect the small list to the start of the large list (after dummy)
        small.next = largeDummy.next;

        return smallDummy.next;
    }

    // Helper method to print the list
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: [1,4,3,2,5,2], x = 3
        ListNode head1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        System.out.print("Input: ");
        solution.printList(head1);
        ListNode res1 = solution.partition(head1, 3);
        System.out.print("Output: ");
        solution.printList(res1);
        // Expected: 1 -> 2 -> 2 -> 4 -> 3 -> 5

        // Test Case 2: [2,1], x = 2
        ListNode head2 = new ListNode(2, new ListNode(1));
        System.out.print("Input: ");
        solution.printList(head2);
        ListNode res2 = solution.partition(head2, 2);
        System.out.print("Output: ");
        solution.printList(res2);
        // Expected: 1 -> 2
    }
}
