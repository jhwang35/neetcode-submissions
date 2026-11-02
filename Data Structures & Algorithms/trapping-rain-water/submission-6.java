class Solution {
    public int trap(int[] height) {
        // if left is <= middle, then we should move on 
        // if left is > middle, take the difference in height between the two and increment right only
        // only use two pointers

        int res = 0;

        if(height.length < 3){ // need at least 3 heights to form a bucket of water
            return res;
        }

        int l = 0;
        int r = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (l < r){
            if (height[l] < height[r]){
                if (height[l] >= leftMax){
                    leftMax = height[l];
                }
                else{
                    res += leftMax - height[l];
                }
                l++;
            }
            else{
                if (height[r] >= rightMax){
                    rightMax = height[r];
                }
                else{
                    res += rightMax - height[r];
                }
                r--;
            }
        }
        return res;

    }
}
