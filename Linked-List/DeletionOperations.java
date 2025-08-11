public class DeletionOperations {

    // Node class definition
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Utility function to print the list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 1️⃣ Delete the head node
    public static Node deleteHead(Node head) {
        if (head == null) return null;
        return head.next; // New head is the second node
    }

    // 2️⃣ Delete the tail node
    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) return null; // Empty or one node

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null; // Remove reference to last node
        return head;
    }

    // 3️⃣ Delete node at given position (1-based index)
    public static Node deleteAtPosition(Node head, int k) {
        if (k <= 0) return head; // Invalid position

        if (k == 1) return deleteHead(head); // Deleting first node

        Node temp = head;
        int count = 1;

        while (temp != null && count < k - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            return head; // Position out of bounds
        }

        temp.next = temp.next.next; // Remove kth node
        return head;
    }

    // 4️⃣ Delete first node with the given value
    public static Node deleteByValue(Node head, int val) {
        if (head == null) return null;

        if (head.data == val) return head.next; // Delete head if it matches

        Node temp = head;
        while (temp.next != null && temp.next.data != val) {
            temp = temp.next;
        }

        if (temp.next == null) {
            return head; // Value not found
        }

        temp.next = temp.next.next; // Delete the node with matching value
        return head;
    }

    // Utility: Create a list from array
    public static Node arrayToList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Node head = arrayToList(arr);

        System.out.println("Original List:");
        printList(head);

        // Test delete head
        head = deleteHead(head);
        System.out.println("After deleting head:");
        printList(head);

        // Test delete tail
        head = deleteTail(head);
        System.out.println("After deleting tail:");
        printList(head);

        // Test delete at position k (e.g., k = 2)
        head = deleteAtPosition(head, 2);
        System.out.println("After deleting node at position 2:");
        printList(head);

        // Test delete by value (e.g., 30)
        head = deleteByValue(head, 30);
        System.out.println("After deleting node with value 30:");
        printList(head);
    }
}
