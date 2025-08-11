public class MiddleOfLinkedList {

    // Definition of the Node (ListNode)
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to create a linked list from an array
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

    // Function to print the linked list (optional for debugging)
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Function to find the middle of the linked list using fast and slow pointers
    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        // Move fast by 2 steps and slow by 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When fast reaches end, slow will be at the middle
        return slow;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6}; // Change to test different cases
        Node head = arrayToList(arr);

        System.out.println("Original Linked List:");
        printList(head);

        Node middle = middleNode(head);
        System.out.println("Middle Node Value: " + middle.val);
    }
}
