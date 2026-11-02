class Solution {
    public int maxProfit(int[] prices) {
        // sliding window 
        // if buyPrice < curr, then we can check to sell
        // window shrinks when we find a cheaper element

        if (prices.length == 0){
            return 0;
        }

        int res = 0;
        
        int buyPrice = prices[0];
        for (int i = 0; i < prices.length; i++){
            int curr = prices[i];
            
            if (buyPrice < curr){ // profit, check if largest profit seen
                int diff = curr - buyPrice;
                res = Math.max (res, diff);
            }
            else{
                buyPrice = curr;
            }

        }
        return res;
    }
}
