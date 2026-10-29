class Solution {
    public int[] productExceptSelf(int[] nums) {
        // first find where all zeros are located, 
        // if more than two zeros then the product will always be 0
        // next calculate it without the zero

        ArrayList<Integer> zeros = new ArrayList<>();
        boolean containsZero = false;
        int length = nums.length;
        int prod = 1;
        int[] res = new int[length];

        for (int i = 0; i < length; i++){
            if (nums[i] == 0){
                zeros.add(i);
                containsZero = true;
            }
            else{ // add to product
                prod *= nums[i];
            }

        }
        
        for (int j = 0; j < length; j++){
            int currNum = nums[j];
            if (zeros.size() > 1){ // means your product will always be zero
                return new int[length];
            }
            if(containsZero && j != zeros.get(0)){
                res[j] = 0;
            }
            else if (currNum == 0 && zeros != null){
                res[j] = prod;
            }
            else{
                res[j] = prod / currNum;
            }     
        }
        return res;
    }
}  
