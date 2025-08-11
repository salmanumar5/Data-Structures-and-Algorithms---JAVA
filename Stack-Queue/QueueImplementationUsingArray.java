public class QueueImplementationUsingArray {

    // Circular Queue class using fixed-size array
    static class Queue {
        private int size;       // Maximum capacity of the queue
        private int[] q;        // Underlying array to store elements
        private int currSize;   // Current number of elements in the queue
        private int start;      // Index of front element
        private int end;        // Index of rear element

        // Constructor
        Queue(int capacity) {
            this.size = capacity;
            this.q = new int[capacity];
            this.currSize = 0;
            this.start = -1;
            this.end = -1;
        }

        /**
         * Inserts an element into the queue (enqueue).
         * Time Complexity: O(1)
         */
        public void push(int x) {
            if (currSize == size) {
                System.out.println("Queue Overflow: Cannot enqueue " + x);
                return;
            }

            // First element to insert
            if (currSize == 0) {
                start = 0;
                end = 0;
            } else {
                end = (end + 1) % size; // Circular increment
            }

            q[end] = x;
            currSize++;

            System.out.println("Enqueued: " + x);
        }

        /**
         * Removes the front element from the queue (dequeue).
         * Time Complexity: O(1)
         */
        public void pop() {
            if (currSize == 0) {
                System.out.println("Queue Underflow: No element to dequeue");
                return;
            }

            System.out.println("Dequeued: " + q[start]);

            // Last remaining element
            if (currSize == 1) {
                start = -1;
                end = -1;
            } else {
                start = (start + 1) % size;
            }

            currSize--;
        }

        /**
         * Returns the front element without removing it.
         * Time Complexity: O(1)
         */
        public int peek() {
            if (currSize == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            return q[start];
        }

        /**
         * Returns the current number of elements in the queue.
         */
        public int size() {
            return currSize;
        }

        /**
         * Checks if the queue is empty.
         */
        public boolean isEmpty() {
            return currSize == 0;
        }

        /**
         * Checks if the queue is full.
         */
        public boolean isFull() {
            return currSize == size;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5); // Create a queue with capacity 5

        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Front element: " + q.peek()); // Should print 10
        System.out.println("Queue size: " + q.size());    // Should print 3

        q.pop(); // Removes 10
        q.pop(); // Removes 20

        System.out.println("Front element: " + q.peek()); // Should print 30
        System.out.println("Queue size: " + q.size());    // Should print 1

        q.pop(); // Removes 30
        q.pop(); // Underflow
    }
}
