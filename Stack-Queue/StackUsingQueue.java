import java.util.LinkedList;
import java.util.Queue;

/**
 * Stack implementation using a single queue (LeetCode #225).
 * 
 * This implementation uses a single queue and simulates LIFO behavior
 * by rotating the queue after each push.
 * 
 * Time Complexity:
 * - push(x): O(n)
 * - pop(): O(1)
 * - top(): O(1)
 * - empty(): O(1)
 */
public class StackUsingQueue {

    // Underlying data structure: single queue
    private Queue<Integer> q;

    // Constructor to initialize the queue
    public StackUsingQueue() {
        q = new LinkedList<>();
    }

    /**
     * Pushes an element onto the stack.
     * We rotate the queue so the newly added element comes to the front.
     */
    public void push(int x) {
        q.add(x); // Step 1: Enqueue the new element
        int size = q.size();

        // Step 2: Rotate the previous elements to the back of the new element
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    /**
     * Removes and returns the top element of the stack.
     * Since the top element is always at the front of the queue,
     * we can directly dequeue.
     */
    public int pop() {
        return q.remove();
    }

    /**
     * Returns the top element of the stack without removing it.
     * The front of the queue is the current "top" of the stack.
     */
    public int top() {
        return q.peek();
    }

    /**
     * Checks whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }

    // Sample usage for local testing
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(10);
        stack.push(20);
        System.out.println("Top: " + stack.top());   // 20
        System.out.println("Pop: " + stack.pop());   // 20
        System.out.println("Is empty: " + stack.empty()); // false
        System.out.println("Pop: " + stack.pop());   // 10
        System.out.println("Is empty: " + stack.empty()); // true
    }
}
