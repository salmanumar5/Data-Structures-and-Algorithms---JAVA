// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /**
     * Removes the N-th node from the end of the linked list.
     * 
     * Approach:
     * 1. Use two pointers: fast and slow.
     * 2. Move the fast pointer n steps ahead so that there is a gap of n nodes between fast and slow.
     * 3. Then move both fast and slow together until fast reaches the last node.
     * 4. At this point, slow will be pointing to the node just before the one we want to remove.
     * 5. Adjust the links to remove the target node.
     * 
     * Edge Case:
     * - If fast becomes null after moving n steps, it means we need to remove the head node (because n == length of list).
     * 
     * Time Complexity: O(L), where L = length of the linked list.
     * Space Complexity: O(1), because we are using only two pointers.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize fast pointer to head
        ListNode fast = head;

        // Move the fast pointer 'n' steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast becomes null, it means the node to delete is the head node
        if (fast == null) {
            return head.next;
        }

        // Initialize slow pointer to head
        ListNode slow = head;

        // Move both pointers one step at a time until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Now, slow is just before the node we want to delete
        slow.next = slow.next.next;

        // Return the (possibly new) head of the list
        return head;
    }
}

// Helper class to create and print linked lists
class LinkedListUtil {
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to test the functionality
public class Main {
    public static void main(String[] args) {
        // Create a linked list from array [1, 2, 3, 4, 5]
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = LinkedListUtil.createList(arr);

        System.out.println("Original List:");
        LinkedListUtil.printList(head);

        Solution solution = new Solution();
        int n = 2; // Remove the 2nd node from the end
        head = solution.removeNthFromEnd(head, n);

        System.out.println("List after removing " + n + "-th node from end:");
        LinkedListUtil.printList(head);
    }
}
