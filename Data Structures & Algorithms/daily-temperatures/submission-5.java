class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // on the stack we will store the index of the given day
        // this way we can check on the stack what day the highest temp was and return accordingly
        // if the temperature is lower than the stack, take the difference of the indexes
        // otherwise replace it 

        int length = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[length];

        if (temperatures.length == 0){
            return res;
        }

        for (int day = length - 1; day >= 0; day--){
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[day]){
                // pop until we find a warmer day than today
                stack.pop();
            }

            if (!stack.isEmpty()){ // we found a day that is warmer so take the diff
                res[day] = stack.peek() - day;
            }
            stack.push(day);
            
        }
        return res;
    }
}