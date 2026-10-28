class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // do we need to iterate throgugh twice?
        // one loop per word? and then another loop for letters?


        List<List<String>> res = new ArrayList<>();
        if (strs == null){
            return res;
        }
        
        Set<String> used = new HashSet<>();
        // loop through all words in strs
        for (int wordI = 0; wordI < strs.length; wordI++){
            if (used.contains(strs[wordI])){ // go to next word if alr used 
                continue;
            }
            used.add(strs[wordI]);
            String currWord = strs[wordI];

            List<String> subList = new ArrayList<>(); // create sublist for current word and all associated
            subList.add(currWord);

            for (int j = wordI + 1; j < strs.length; j++){ // compare against all other words
                int[] counts = new int[26];
                String compWord = strs[j];
                if (currWord.length() == compWord.length()){ // individual letters
                    for(int i = 0; i < currWord.length(); i ++){
                        counts[currWord.charAt(i) - 'a']++;
                        counts[compWord.charAt(i) - 'a']--;
                    }
                }
                else{
                    continue;
                }
                // check counts
                boolean isAnagram = true;
                for (int value: counts){
                    if (value != 0){
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram){ // add it to the used words and subarray
                    subList.add(compWord);
                    used.add(compWord);
                }

            }
            res.add(subList);
        }
        return res;
    }
}
