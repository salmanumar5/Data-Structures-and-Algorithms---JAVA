public class CheckLinkedListPalindrome {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Checks whether the linked list is a palindrome.
     *
     * ✅ Approach:
     * - Use two pointers (slow and fast) to find the middle of the list.
     * - Reverse the second half of the list.
     * - Compare the first half and the reversed second half node by node.
     * - Restore the reversed half (optional, but good practice).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head The head of the singly linked list
     * @return true if the list is a palindrome, false otherwise
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Find middle using slow and fast pointer
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half of the list
        ListNode secondHalfStart = reverse(slow.next);

        // Step 3: Compare both halves
        ListNode first = head;
        ListNode second = secondHalfStart;

        while (second != null) {
            if (first.val != second.val) {
                reverse(secondHalfStart); // Restore original list
                return false;
            }
            first = first.next;
            second = second.next;
        }

        // Step 4: Optional — restore the original structure
        reverse(secondHalfStart);

        return true;
    }

    // Utility: Reverses a linked list from given node
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next; // Save next
            current.next = prev;          // Reverse link
            prev = current;               // Move prev forward
            current = next;               // Move current forward
        }

        return prev;
    }

    // Sample test to check palindrome logic
    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 2 -> 1
        ListNode n5 = new ListNode(1);
        ListNode n4 = new ListNode(2, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);

        boolean result = isPalindrome(head);
        System.out.println("Is palindrome? " + result);
    }
}
