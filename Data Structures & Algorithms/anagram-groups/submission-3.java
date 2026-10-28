class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create a hashmap, frequency counts are the key and the words associated are the value
        // frequency count is an array, we later convert to string after each iteration
        // if the count matches what we have stored, then add it that key, else make a new entry
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs){
            int[] counts = new int[26];

            for (char c: s.toCharArray()){
                counts[c - 'a']++;
            }

            String key = Arrays.toString(counts);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
