class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // two pointer approach
        // sort array
        // fixed pointer at one index
        // left and right pointers, adjust according to sum
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 3 ){
            return res;
        }

        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++){ // need at least 3 elements left
            int l = i + 1;
            int r = nums.length - 1;
            // perform two pointer
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                List<Integer> curr = new ArrayList<>(List.of(nums[i], nums[l], nums[r]));
                if (sum == 0 && res.contains(curr) == false){
                    res.add(curr);
                    l++;
                    r--;
                }
                else if (sum > 0){
                    r--;
                }
                else if(sum < 0){
                    l++;
                }
                else{
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
