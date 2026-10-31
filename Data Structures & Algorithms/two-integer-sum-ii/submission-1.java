class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // original two sum: use hashmap to store [target,index]
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i + 1);
        }

        for (int j = 0; j < numbers.length; j++){
            int diff = target - numbers[j];

            if (map.containsKey(diff) && j < map.get(diff)){
                res[0] = j + 1;
                res[1] = map.get(diff);
                return res;
            }
        }
        return res;
    }
}
