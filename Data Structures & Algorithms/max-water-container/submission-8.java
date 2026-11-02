class Solution {
    public int maxArea(int[] heights) {
        // calculate the width * the min height
        // move smallest height pointer
        int res = 0;

        if(heights.length == 0 ){
            return res;
        }

        int l = 0;
        int r = heights.length - 1;

        while (l < r){
            int height = Math.min(heights[l], heights[r]);
            int width = r - l;
            int area = height * width;

            res = Math.max(area, res);
            
            if(heights[l] > heights[r]){
                r--;
            }
            else if(heights[l] < heights[r]){
                l++;
            }
            else{
                l++;
                r--;
            }

        }
        return res;
    }
}
