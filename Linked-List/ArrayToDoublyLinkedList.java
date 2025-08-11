public class ArrayToDoublyLinkedList {

    // Node class for doubly linked list
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    /**
     * Converts an integer array to a Doubly Linked List
     *
     * Approach:
     * - Create the head node from the first element
     * - Iterate through the array and for each value:
     *   - Create a new node
     *   - Link the previous node's next to this node
     *   - Set the current node's prev to the previous node
     * - Move the previous pointer forward
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static Node arrayToDLL(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node current = new Node(arr[i]);
            prev.next = current;
            current.prev = prev;
            prev = current;
        }

        return head;
    }

    // Utility: Print DLL forward
    public static void printForward(Node head) {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Utility: Print DLL backward (from tail)
    public static void printBackward(Node tail) {
        Node temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Utility: Get tail of DLL
    public static Node getTail(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    // Test the conversion
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        Node head = arrayToDLL(arr);

        printForward(head);
        Node tail = getTail(head);
        printBackward(tail);
    }
}
