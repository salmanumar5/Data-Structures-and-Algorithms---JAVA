public class OddEvenLinkedList {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Reorders the linked list by grouping all odd-indexed nodes first,
     * followed by all even-indexed nodes.
     *
     * ✅ Intuition:
     * - Odd/even here refers to the node **positions** (1-based index), not values.
     * - Traverse using two pointers: one for odd positions and one for even positions.
     * - Rearrange the next pointers accordingly.
     * - At the end, connect the last odd node to the head of even nodes.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head The head of the linked list
     * @return The reordered linked list
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Start of odd and even nodes
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next; // Store start of even list to connect later

        // Traverse while even and even.next exist
        while (even != null && even.next != null) {
            // Link current odd node to the next odd node
            odd.next = even.next;
            odd = odd.next;

            // Link current even node to the next even node
            even.next = odd.next;
            even = even.next;
        }

        // Append the even list at the end of the odd list
        odd.next = evenHead;

        return head;
    }

    // Sample test
    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);

        ListNode result = oddEvenList(head);

        // Print result: Expected 1 -> 3 -> 5 -> 2 -> 4
        System.out.print("Reordered list: ");
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}
