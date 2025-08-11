public class InsertionOperations {

    // Node class definition
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 1️⃣ Insert at head
    public static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    // 2️⃣ Insert at tail
    public static Node insertAtTail(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) return newNode; // Empty list becomes new head

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // 3️⃣ Insert at position k (1-based index)
    public static Node insertAtPosition(Node head, int data, int k) {
        if (k <= 0) return head; // Invalid position

        if (k == 1) {
            return insertAtHead(head, data);
        }

        Node newNode = new Node(data);
        Node temp = head;
        int count = 1;

        while (temp != null && count < k - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            return head; // Position out of bounds
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    // 4️⃣ Insert after the first node with given value
    public static Node insertAfterValue(Node head, int valueToFind, int dataToInsert) {
        Node temp = head;

        while (temp != null && temp.data != valueToFind) {
            temp = temp.next;
        }

        if (temp == null) {
            return head; // Value not found
        }

        Node newNode = new Node(dataToInsert);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    // Utility: Convert array to linked list
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

    // Main method to test all insertions
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        Node head = arrayToList(arr);

        System.out.println("Original List:");
        printList(head);

        head = insertAtHead(head, 5);
        System.out.println("After inserting 5 at head:");
        printList(head);

        head = insertAtTail(head, 40);
        System.out.println("After inserting 40 at tail:");
        printList(head);

        head = insertAtPosition(head, 25, 4);
        System.out.println("After inserting 25 at position 4:");
        printList(head);

        head = insertAfterValue(head, 20, 22);
        System.out.println("After inserting 22 after value 20:");
        printList(head);
    }
}
