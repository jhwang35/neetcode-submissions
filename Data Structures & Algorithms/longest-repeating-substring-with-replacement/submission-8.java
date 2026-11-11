class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window, one pass through
        // iterate r until we reach a value
        // hashmap to store how much each character occurs
        HashMap<Character, Integer> map = new HashMap<>();


    
        int res = 0;
        int maxFreq = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++){
            char c = s.charAt(r);

            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c)); 
            
            // shrink if the amount of remaining characters exceedes k
            
            while ((r - l + 1) - maxFreq > k){ // tells us the remaining characters that can be replaced
                char left = s.charAt(l);
                map.put(left, map.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;


    }
}
