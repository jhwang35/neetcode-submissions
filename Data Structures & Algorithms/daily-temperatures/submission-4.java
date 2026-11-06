class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int length = temperatures.length;

        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int day = length - 1; day >= 0; day--) {

            while (!stack.isEmpty() &&
                   temperatures[stack.peek()] <= temperatures[day]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                res[day] = stack.peek() - day;
            }

            stack.push(day);
        }

        return res;
    }
}