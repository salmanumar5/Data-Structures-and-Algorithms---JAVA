import java.util.*;

class AsteroidCollision {

    /**
     * This method simulates asteroid collisions.
     * Each asteroid moves at the same speed, but in opposite directions.
     * Positive values move right, negative values move left.
     * When two asteroids collide:
     *   - The smaller one explodes.
     *   - If equal in size, both explode.
     *   - If moving in the same direction, no collision happens.
     *
     * Time Complexity: O(n), where n is the number of asteroids.
     * Space Complexity: O(n), for the list used to simulate a stack.
     */
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> st = new ArrayList<>();

        for (int i = 0; i < asteroids.length; i++) {
            // If current asteroid is moving right, it can be safely added to the stack
            if (asteroids[i] > 0) {
                st.add(asteroids[i]);
                continue;
            }

            // If current asteroid is moving left, check for collisions with top of stack
            while (!st.isEmpty() && st.get(st.size() - 1) > 0 && st.get(st.size() - 1) < Math.abs(asteroids[i])) {
                // Top of stack is a smaller asteroid moving right -> it explodes
                st.remove(st.size() - 1);
            }

            // If the top of stack asteroid is equal in size -> both explode
            if (!st.isEmpty() && st.get(st.size() - 1) == Math.abs(asteroids[i])) {
                st.remove(st.size() - 1);
            }
            // If stack is empty or top is also a left-moving asteroid -> no collision, add it
            else if (st.isEmpty() || st.get(st.size() - 1) < 0) {
                st.add(asteroids[i]);
            }
        }

        // Convert list to array before returning
        return st.stream().mapToInt(i -> i).toArray();
    }

    // Sample main method to run and test the code
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input1 = {5, 10, -5};
        int[] input2 = {8, -8};
        int[] input3 = {10, 2, -5};
        int[] input4 = {-2, -1, 1, 2};

        System.out.println("Result 1: " + Arrays.toString(sol.asteroidCollision(input1))); // [5, 10]
        System.out.println("Result 2: " + Arrays.toString(sol.asteroidCollision(input2))); // []
        System.out.println("Result 3: " + Arrays.toString(sol.asteroidCollision(input3))); // [10]
        System.out.println("Result 4: " + Arrays.toString(sol.asteroidCollision(input4))); // [-2, -1, 1, 2]
    }
}
