class Solution {
    public int[] twoSum(int[] nums, int target) {
        // two pointer
        // hashmap store indices and loop once 

        if (nums == null){
            return null;
        }

        int[] res = new int[2];
        int diff =  0;
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            myMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            diff = target - nums[i];
            if (myMap.containsKey(diff) && i != myMap.get(diff)){
                res[0] = i;
                res[1] = myMap.get(diff);
                return res;
            }
        }
        return res;

        
    }
}
