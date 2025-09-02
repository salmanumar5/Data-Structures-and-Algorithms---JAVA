/**
 * ✅ Approach:

Edge Cases
If the list is empty, has only one node, or k = 0, return the head as is.

Find Length and Tail
Traverse the list to find its length (len) and the last node (tail).

Optimize k
If k is greater than len, take k % len because rotating len times results in the same list.
If k % len == 0, return head.

Make it Circular
Connect the tail.next to head, forming a circular linked list.

Find New Head
The new head is (len - k) steps from the start.
Break the circle by setting the (len - k)th node's next to null.

Return New Head
Return the new head after rotation.
 * 
 * 
 */

public class RotateList {

    // Nested static class for ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode findNthNode(ListNode temp, int n){
        int cnt = 1;
        while(temp != null){
            if(cnt == n) break;
            cnt++;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head;
        int len = 1; 

        while(tail.next != null){
            tail = tail.next;
            len++;
        }

        if(k % len == 0) return head;

        k = k % len;
        tail.next = head;

        ListNode newLastNode = findNthNode(head, len - k);
        head = newLastNode.next;
        newLastNode.next = null;

        return head;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Create Linked List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2; // Number of rotations

        System.out.println("Original List:");
        printList(head);

        ListNode rotatedHead = sol.rotateRight(head, k);

        System.out.println("Rotated List:");
        printList(rotatedHead);
    }

    // Helper method to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
