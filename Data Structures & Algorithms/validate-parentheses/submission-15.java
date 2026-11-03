class Solution {
    public boolean isValid(String s) {
        // map closed to open parenthesis
        // add opens to stack, if closed is found, pop off stack
        // stack should be emptied

        HashMap<Character, Character> pMap = new HashMap<>(Map.of('}','{',']','[',')','('));
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char p = s.charAt(i);
            if (!charStack.isEmpty() && pMap.containsKey(p) && charStack.peek() == pMap.get(p)){
                charStack.pop();
            }
            else {
                charStack.push(p);
            }

        }
        return charStack.size() == 0;
    }
}
