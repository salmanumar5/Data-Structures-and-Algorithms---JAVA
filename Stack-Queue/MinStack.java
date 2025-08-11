import java.util.*;

/**
 * MinStack implementation using encoding to track the minimum in O(1) time and O(1) space.
 * Uses a clever trick:
 * - When pushing a new minimum, we store an encoded value: (2 * val - min)
 * - On pop, if the top value is less than current min, we decode the previous min using: (2 * min - encodedTop)
 */
class MinStack {
    private Stack<Long> st; // Stack to store either raw values or encoded ones
    private long min;       // Stores the current minimum

    /** Initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
    }

    /** Push element val onto stack. */
    public void push(int val) {
        long x = val;

        if (st.isEmpty()) {
            st.push(x);    // First element, push as is
            min = x;
        } else {
            if (x < min) {
                // Encode the value before pushing to preserve previous min
                st.push(2 * x - min);
                min = x;
            } else {
                // Normal push
                st.push(x);
            }
        }
    }

    /** Removes the element on the top of the stack. */
    public void pop() {
        if (st.isEmpty()) return;

        long top = st.pop();

        // If top is less than current min, it was an encoded value
        if (top < min) {
            // Recover the previous minimum
            min = 2 * min - top;
        }
    }

    /** Get the top element. */
    public int top() {
        long top = st.peek();

        // If encoded, return current min as actual top
        if (top < min) {
            return (int) min;
        } else {
            return (int) top;
        }
    }

    /** Retrieve the minimum element in the stack. */
    public int getMin() {
        return (int) min;
    }

    /** Main method to test locally */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(5);
        System.out.println("Pushed 5 | Min: " + minStack.getMin()); // 5

        minStack.push(3);
        System.out.println("Pushed 3 | Min: " + minStack.getMin()); // 3

        minStack.push(2);
        System.out.println("Pushed 2 | Min: " + minStack.getMin()); // 2

        minStack.pop();
        System.out.println("Popped   | Top: " + minStack.top());    // 3
        System.out.println("         | Min: " + minStack.getMin()); // 3

        minStack.pop();
        System.out.println("Popped   | Top: " + minStack.top());    // 5
        System.out.println("         | Min: " + minStack.getMin()); // 5
    }
}
