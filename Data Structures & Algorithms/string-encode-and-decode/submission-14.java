class Solution {
    // combine words into a string with words split by a symbol
    // when decrypting the symbol will indicate the end of a word 
    // two pointer decryption to mark start and end of word, from there splice that part as a new string
    public String encode(List<String> strs) {
        String res = "";
        
        if (strs == null){
            return res;
        }

        for (String s: strs){
            res += s.concat("\n");
        }
        return res;
    }

    public List<String> decode(String str) {
        if (str == null){
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        int l = 0;
        int r = 0; 

        while (r < str.length()){
            while (str.charAt(r) != '\n'){
                r++; 
            }
                String word = str.substring(l,r);
                res.add(word);
                r++;
                l = r;

            
        }
        return res;

    }
}
