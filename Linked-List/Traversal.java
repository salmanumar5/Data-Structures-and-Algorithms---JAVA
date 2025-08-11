public class Traversal {

    // Node class to define structure of each linked list node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to calculate the length of the linked list
    public static int getLength(Node head) {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // Function to search for an element in the linked list
    public static boolean searchElement(Node head, int target) {
        Node current = head;

        while (current != null) {
            if (current.data == target) {
                return true; // Found the target
            }
            current = current.next;
        }

        return false; // Target not found
    }

    // Utility function to print the linked list (optional)
    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Main method to test traversal functions
    public static void main(String[] args) {
        // Create sample linked list: 10 -> 20 -> 30 -> null
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        // Print the list
        System.out.println("Linked List:");
        printList(head);

        // Get and print length
        int length = getLength(head);
        System.out.println("Length of Linked List: " + length);

        // Search for elements
        int target1 = 20;
        int target2 = 40;

        System.out.println("Is " + target1 + " present? " + searchElement(head, target1));
        System.out.println("Is " + target2 + " present? " + searchElement(head, target2));
    }
}
