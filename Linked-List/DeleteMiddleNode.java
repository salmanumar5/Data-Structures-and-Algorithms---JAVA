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

public class DeleteMiddleNode {

    /**
     * Deletes the middle node of a linked list.
     * If the list has an even number of nodes, it removes the second middle node.
     *
     * @param head the head of the linked list
     * @return the head of the modified linked list
     */
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: If list is empty or has only one node, return null
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Move fast two steps ahead initially
        fast = fast.next.next;

        // Move slow by one and fast by two steps until fast reaches end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        slow.next = slow.next.next;

        // Return the head of the modified list
        return head;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Create Solution object
        DeleteMiddleNode solution = new DeleteMiddleNode();

        // Delete middle node
        head = solution.deleteMiddle(head);

        // Print modified linked list
        System.out.print("Modified Linked List: ");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
