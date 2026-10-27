class Solution {
    public boolean isAnagram(String s, String t) {
        // can sort both strings and then compare
        // can also create a map with counts and compare after another iteration 

        // base case check lengths 
        if (s.length() == 0 || t.length() == 0){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> myMap = new HashMap<>();

        // loop through first string and list occurences
        for (int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if (myMap.containsKey(character)){
                myMap.put(character, myMap.get(character) + 1);
            }
            else{
                myMap.put(character, 1);
            }
        }

        HashMap<Character, Integer> tMap = new HashMap<>();

        // loop through first string and list occurences
        for (int i = 0; i < t.length(); i++){
            char character = t.charAt(i);
            if (tMap.containsKey(character)){
                tMap.put(character, tMap.get(character) + 1);
            }
            else{
                tMap.put(character, 1);
            }
        }

        return myMap.equals(tMap);
    }
}
