class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use a single array to hold all letters and counts
        // at the same time loop through the array to store the common words
        // should also skip strings that have already been used

        if (strs == null) {
            return null;
        }

        List<List<String>> res = new ArrayList<>();
        boolean[] used = new boolean[strs.length];

        for (int wordI = 0; wordI < strs.length; wordI++) {
            if (used[wordI]) {
                continue;
            }

            String word = strs[wordI];
            List<String> subList = new ArrayList<>();
            subList.add(word);
            used[wordI] = true;

            for (int nextI = wordI + 1; nextI < strs.length; nextI++) {
                if (used[nextI]) {
                    continue;
                }

                String nextWord = strs[nextI];

                if (word.length() != nextWord.length()) {
                    continue;
                }

                int[] myArr = new int[26];

                for (int i = 0; i < word.length(); i++) {
                    myArr[word.charAt(i) - 'a']++;
                    myArr[nextWord.charAt(i) - 'a']--;
                }

                boolean isAnagram = true;

                for (int value : myArr) {
                    if (value != 0) {
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram) {
                    subList.add(nextWord);
                    used[nextI] = true;
                }
            }

            res.add(subList);
        }

        return res;
    }
}
