public class StackImplementationUsingArray {

    // Stack class using fixed-size array
    static class Stack {
        private int top;       // Index of top element
        private int[] arr;     // Array to hold stack elements
        private int capacity;  // Maximum stack size

        // Constructor
        Stack(int capacity) {
            this.capacity = capacity;
            this.arr = new int[capacity];
            this.top = -1; // Initially stack is empty
        }

        /**
         * Pushes an element onto the stack.
         * Time Complexity: O(1)
         */
        public void push(int x) {
            if (top >= capacity - 1) {
                System.out.println("Stack Overflow: Cannot push " + x);
                return;
            }

            top++;
            arr[top] = x;
            System.out.println("Pushed: " + x);
        }

        /**
         * Pops the top element from the stack.
         * Time Complexity: O(1)
         */
        public void pop() {
            if (top == -1) {
                System.out.println("Stack Underflow: No element to pop");
                return;
            }

            System.out.println("Popped: " + arr[top]);
            top--;
        }

        /**
         * Returns the top element without removing it.
         * Time Complexity: O(1)
         */
        public int top() { //also called peek()
            if (top == -1) {
                System.out.println("Stack is empty");
                return -1;
            }
            return arr[top];
        }

        /**
         * Returns the number of elements in the stack.
         */
        public int size() {
            return top + 1;
        }

        /**
         * Checks if the stack is empty.
         */
        public boolean isEmpty() {
            return top == -1;
        }
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        Stack st = new Stack(10); // Create stack of capacity 10

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Current top: " + st.peek()); // Should print 30
        System.out.println("Stack size: " + st.size());  // Should print 3

        st.pop(); // Removes 30
        st.pop(); // Removes 20

        System.out.println("Current top: " + st.peek()); // Should print 10
        System.out.println("Stack size: " + st.size());  // Should print 1

        st.pop(); // Removes 10
        st.pop(); // Underflow
    }
}
