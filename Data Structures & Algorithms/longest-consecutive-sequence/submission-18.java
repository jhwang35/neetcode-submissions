class Solution {
    public int longestConsecutive(int[] nums) {
        // set approach
        // create a set with all the numbers,
        // if the next number is found in our set then increment by one
        // otherwise reset the count and 


        Set<Integer> numSet = new HashSet<>();
        int res = 0;
        for (int num : nums){
            numSet.add(num);
        }

        for (int num : numSet){
            if (!numSet.contains(num-1)){ // start of new sequence
                int length = 1;
                while (numSet.contains(num + length)){
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }
}
