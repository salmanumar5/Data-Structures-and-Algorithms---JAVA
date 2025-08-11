public class ArrayToLinkedList {

    // Node class to represent each element in the linked list
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to convert array to linked list
    public static Node arrayToList(int[] arr) {
        if (arr.length == 0) return null; // Empty array case

        Node head = new Node(arr[0]); // Create head from first element
        Node current = head;          // Temp pointer to build the list

        // Loop through the rest of the array
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]); // Create a new node
            current.next = newNode;          // Link it to the previous node
            current = newNode;               // Move current forward
        }

        return head; // Return the head of the linked list
    }

    // Utility function to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the conversion
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        Node head = arrayToList(arr);

        System.out.println("Linked List constructed from array:");
        printList(head);
    }
}
