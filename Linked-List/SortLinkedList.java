// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortLinkedList {

    // Merge two sorted linked lists into one sorted list
    public ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // Dummy node for easy merge handling
        ListNode temp = dummy;

        // Merge both lists in sorted order
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // Attach the remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummy.next; // Return merged sorted list
    }

    // Find the middle node using slow and fast pointer approach
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // Start fast one step ahead for correct split

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Middle node
    }

    // Main function to sort the linked list using Merge Sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: empty or single node list
        }

        // Step 1: Find the middle node
        ListNode middle = findMiddle(head);

        // Step 2: Split into two halves
        ListNode rightHead = middle.next;
        middle.next = null; // Break the link to split the list
        ListNode leftHead = head;

        // Step 3: Recursively sort both halves
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        // Step 4: Merge the two sorted halves
        return mergeTwoSortedList(leftHead, rightHead);
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test the sorting
    public static void main(String[] args) {
        // Creating unsorted linked list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        SortLinkedList obj = new SortLinkedList();
        head = obj.sortList(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
