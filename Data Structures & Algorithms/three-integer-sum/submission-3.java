class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // break down into a two sum problem, then look for a third number to add 
        List<List<Integer>> res = new ArrayList<>(); 
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        if (nums.length < 3){
            return new ArrayList<>();
        }

        for (int i = 0; i < copy.length - 2; i++){ // need at least two elements to form triplet
            if (i > 0 && copy[i] == copy[i - 1]){
                continue;
            }
            int l = i + 1;
            int r = copy.length - 1;

            while (l < r){
                int target = copy[l] + copy[r] + copy[i];
                
                if(target > 0){
                    r--;
                }
                else if (target < 0){
                    l++;
                }
                else{
                    List<Integer> sum = new ArrayList<>(List.of(copy[i], copy[l], copy[r]));
                    res.add(sum);
                    l++;
                    r--;

                    while (l < r && copy[l] == copy[l - 1]) {
                        l++;
                    }

                    while (l < r && copy[r] == copy[r + 1]) {
                        r--;
                    }
                }
            }
        }
        

        return res;
        
    }
}
