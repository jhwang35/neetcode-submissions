class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0 ){
            return true;
        }

        // two pointer on both ends iterate at the same time till l = r

        s = s.toLowerCase();

        int l = 0;
        int r = s.length() - 1;

        while (l < r){
            while(!Character.isLetterOrDigit(s.charAt(l)) && l < r){
                l++;
            }
            while(!Character.isLetterOrDigit(s.charAt(r)) && l < r){
                r--;
            }
            // compare characters, if not the same return false
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}
