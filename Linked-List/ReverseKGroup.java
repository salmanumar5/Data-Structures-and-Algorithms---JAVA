public class ReverseKGroup {
    // Static class for ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        // Method to reverse a linked list
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;       // Previous node initially null
            ListNode current = head;    // Current node starts from head

            while (current != null) {
                ListNode next = current.next;  // Store next node
                current.next = prev;           // Reverse the link
                prev = current;                // Move prev forward
                current = next;                // Move current forward
            }
            return prev; // Return new head after reversal
        }

        // Method to get the k-th node from the given node
        public ListNode getKthNode(ListNode temp, int k) {
            k -= 1;  // Adjust because temp is already the 1st node
            while (temp != null && k > 0) {
                k--;
                temp = temp.next; // Move forward until k-th node
            }
            return temp; // Return k-th node or null if not enough nodes
        }

        // Main function to reverse nodes in k-group
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode temp = head;       // Pointer to traverse the list
            ListNode prevNode = null;   // To connect previous group with current group

            while (temp != null) {
                ListNode kthNode = getKthNode(temp, k); // Find k-th node from temp
                if (kthNode == null) {  // If fewer than k nodes remain, stop reversing
                    if (prevNode != null) prevNode.next = temp;
                    break;
                }

                ListNode nextNode = kthNode.next; // Store next node after k-group
                kthNode.next = null;             // Temporarily break the link

                reverseList(temp); // Reverse current k-group

                if (temp == head) {
                    head = kthNode; // Update head for first group
                } else {
                    prevNode.next = kthNode; // Connect previous group to current
                }

                prevNode = temp;    // Move prevNode to end of current reversed group
                temp = nextNode;    // Move temp to start of next group
            }
            return head;
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2; // Group size

        Solution solution = new Solution();
        ListNode result = solution.reverseKGroup(head, k);

        // Print the reversed list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
