public class DetectCycleInLinkedList {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Detects the starting node of a cycle in a linked list, if one exists.
     *
     * ✅ Uses Floyd's Cycle Detection Algorithm (Tortoise and Hare).
     * ✅ If a cycle is found, resets one pointer to head and moves both one step
     *    at a time — they meet at the starting point of the cycle.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head The head of the singly linked list
     * @return The node where the cycle begins, or null if no cycle exists
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if cycle exists using fast and slow pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Cycle detected; now find the entry point
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // Start of the cycle
            }
        }

        return null; // No cycle
    }

    // Test utility (not required by LeetCode but useful for local testing)
    public static void main(String[] args) {
        // Create a cycle manually: 3 -> 2 -> 0 -> -4 -> back to node 2
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates cycle

        ListNode cycleStart = detectCycle(node1);
        if (cycleStart != null) {
            System.out.println("Cycle detected starting at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}

//So the intuition is like if the slow move to the starting point in L1, then fast move ahead L1
//Now as they move in the cycle, the distance between them is d, and to collide fast moves 2d and slow moves d ahead
//The point they collide is d distance from the starting node of cycle and the remaining distance from collide point is now L1
//So if fst moves L1 from collision and slow from the head, they will meet at the starting point of the cycle.