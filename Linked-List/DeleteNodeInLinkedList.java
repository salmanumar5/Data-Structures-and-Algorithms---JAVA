public class DeleteNodeInLinkedList {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Deletes the given node from the linked list.
     *
     * ✅ You're given only the node to be deleted (not the head).
     * ✅ It's guaranteed that the node is not the last node.
     * ✅ All node values are unique.
     *
     * Approach:
     * Since we can't access the previous node or head,
     * we mimic deleting the current node by:
     * 1. Copying the next node's value into the current node
     * 2. Skipping over the next node (unlinking it)
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Utility to create a linked list from array (for testing)
    public static ListNode arrayToList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Utility to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Test case using arrayToList and manual node deletion
    public static void main(String[] args) {
        // Sample linked list: [4, 5, 1, 9]
        int[] arr = {4, 5, 1, 9};
        ListNode head = arrayToList(arr);

        System.out.println("Original list:");
        printList(head);

        // Simulate passing in the '5' node directly (node to be deleted)
        ListNode nodeToDelete = head.next; // node with value 5

        deleteNode(nodeToDelete);

        System.out.println("After deleting node with value 5:");
        printList(head);
    }
}
