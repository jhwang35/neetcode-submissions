class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // stack approach, go in reverse to add current car to stack and work backwards
        // sort to group positions with each other 
        // constraint: car can't pass another car ahead of it 

        // sort positions
        // sliding window checking if the left time > right time, if so we have a group, if not we dont


        // time = target - pos / speed
    
        // edge cases: arrays not same size, arr of size 0
        // hashmap to store the position and the related speed 

        int length = position.length;
        int res = 0;
        
        if (length == 0){
            return 0;
        }
        else if(length == 1){
            return 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();         // store positions and their related speeds
        for (int i = 0; i < length; i++){
            map.put(position[i], speed[i]);
        }

        int[] sortedPos = Arrays.copyOf(position, length);

        Arrays.sort(sortedPos);
        Stack<Double> stack = new Stack<>();

        // go through sorted positions
        // look up the corresponding speed in our map
        for (int i = length - 1; i >= 0; i--){
            double time = (double) (target - sortedPos[i]) / map.get(sortedPos[i]);
           if (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
           }
        }
    
        return stack.size();
        
    }
}
