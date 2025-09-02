/**
 * Approach Explanation (Two Pointer Technique):
Problem: Find the intersection point of two singly linked lists if it exists.
Idea:
Use two pointers, t1 starting at headA and t2 starting at headB.
Move both pointers one step at a time.
When a pointer reaches the end of its list, switch it to the head of the other list.
Why this works:
If the lists intersect, the two pointers will eventually meet at the intersection node after traversing equal total lengths (a + b + c).
If they do not intersect, both will become null at the same time, ending the loop.
Time Complexity: O(m + n) (where m and n are the lengths of the two lists).
Space Complexity: O(1) (no extra space used).
 */

public class IntersectionLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Function to find intersection node
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode t1 = headA;
        ListNode t2 = headB;

        // Traverse both lists
        while (t1 != t2) {
            // Move each pointer forward, if null then switch to the other list
            t1 = (t1 == null) ? headB : t1.next;
            t2 = (t2 == null) ? headA : t2.next;
        }

        return t1; // This will be either the intersection node or null
    }

    // Main method to test
    public static void main(String[] args) {
        // Create first linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);

        // Create second linked list: 9 -> 8 -> (intersection)
        ListNode headB = new ListNode(9);
        headB.next = new ListNode(8);

        // Create the intersection part: 4 -> 5
        ListNode intersection = new ListNode(4);
        intersection.next = new ListNode(5);

        // Attach intersection to both lists
        headA.next.next.next = intersection; // 3 -> 4
        headB.next.next = intersection;      // 8 -> 4

        // Test
        IntersectionLinkedList solution = new IntersectionLinkedList();
        ListNode result = solution.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection Node Value: " + result.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}
