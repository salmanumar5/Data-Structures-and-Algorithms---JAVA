// - Add 2 + 5 = 7 (units place).  
// - Add 4 + 6 = 10 → put 0, carry 1.  
// - Add 3 + 4 + 1(carry) = 8.  

// 2. We simulate the **same addition logic** but using linked lists:
// - Traverse both linked lists at the same time.  
// - Add corresponding digits + carry.  
// - Store `(sum % 10)` in a new node (because only 1 digit can stay).  
// - Update `carry = sum / 10`.  
// - Move forward in both lists until both are processed.  

// 3. If there's a carry left at the end, add one more node.  

// ---


// Definition for singly-linked list

class AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to start the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Traverse both lists until both are null
        while (l1 != null || l2 != null) {
            // Take values if nodes exist, otherwise take 0
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Sum of digits + carry
            int sum = x + y + carry;

            // Next digit = sum % 10
            current.next = new ListNode(sum % 10);

            // Update carry
            carry = sum / 10;

            // Move to next nodes
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If carry is still left, add new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next; // First node was dummy
    }
    }

// Local testing
public class Main {
 public static void printList(ListNode head) {
     while (head != null) {
         System.out.print(head.val + " ");
         head = head.next;
     }
     System.out.println();
 }

 public static void main(String[] args) {
     // l1 = [2,4,3] → represents 342
     ListNode l1 = new ListNode(2);
     l1.next = new ListNode(4);
     l1.next.next = new ListNode(3);

     // l2 = [5,6,4] → represents 465
     ListNode l2 = new ListNode(5);
     l2.next = new ListNode(6);
     l2.next.next = new ListNode(4);

     Solution sol = new Solution();
     ListNode result = sol.addTwoNumbers(l1, l2);

     // Expected output: [7,0,8] → represents 807
     printList(result);
 }
}
