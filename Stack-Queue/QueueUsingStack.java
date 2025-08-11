import java.util.LinkedList;
import java.util.Deque;

/**
 * MyQueue simulates a FIFO (First-In-First-Out) queue using two stacks.
 * 
 * This implementation uses two stacks (s1 and s2) and reverses the stack 
 * during each push operation so that the oldest element stays on top of s1.
 * 
 * Time Complexity:
 *  - push(x): O(n) – due to internal stack reversal
 *  - pop():  O(1)
 *  - peek(): O(1)
 *  - empty(): O(1)
 */
class QueueUsingStack {

    private Deque<Integer> s1; // Main stack (will hold elements in correct queue order)
    private Deque<Integer> s2; // Helper stack (used during push)

    /** Initialize your data structure. */
    public MyQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    /**
     * Push element x to the back of the queue.
     * Logic:
     *  1. Move all elements from s1 to s2.
     *  2. Push new element x onto s1 (now empty).
     *  3. Move all elements back from s2 to s1.
     */
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.remove());  // move all from s1 to s2
        }

        s1.push(x); // insert new element

        while (!s2.isEmpty()) {
            s1.push(s2.remove());  // move everything back to s1
        }
    }

    /**
     * Removes the element from the front of the queue.
     * Since the front is always on top of s1, simply remove.
     */
    public int pop() {
        return s1.remove();
    }

    /**
     * Get the front element without removing it.
     */
    public int peek() {
        return s1.peek();
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean empty() {
        return s1.isEmpty();
    }

    // Example usage (optional for local testing)
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek()); // Output: 1
        System.out.println(q.pop());  // Output: 1
        System.out.println(q.empty()); // Output: false
    }
}
