class Solution {
    public int longestConsecutive(int[] nums) {
        // sort array and loop again

        if (nums.length == 0){
            return 0;
        }


        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int res = 1;
        int seq = 1;
        int l = 0;
        int r = 1;

        while (r < copy.length){
            if (copy[r] == copy[l]) {
                r++;
                continue;
            }
            else if(copy[r] == copy[l] + 1){
                seq++;
                res = Math.max(res,seq);
                l = r;
            }
            else{
                l = r;
                seq = 1;
            }
            
            r++;
        }
        return res;
    }
}
