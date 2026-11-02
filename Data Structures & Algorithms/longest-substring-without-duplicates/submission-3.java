class Solution {
    public int lengthOfLongestSubstring(String s) {
        // set of seen characters
        // take current length of window and increase it
        Set<Character> seen = new HashSet<>();
        
        int maxLen = 0; 
        int l = 0;

        for(int r = 0; r < s.length(); r++){
            while (seen.contains(s.charAt(r))){
                seen.remove(s.charAt(l));
                l++;
            }
                seen.add(s.charAt(r));
                maxLen = Math.max(maxLen, r - l + 1);
            
        }
        return maxLen;
    }
}
