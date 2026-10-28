class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // hashmap to store counts of each number, then loop through to find put them in order and take from reverse

        HashMap<Integer, Integer> countMap = new HashMap<>();
        int[] res = new int[k];

        for (int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // find a way to get the numbers in frequency order
        // list of buckets, this stores the values that appear x amount of times
        // ex. if 1 and 3 appear once, they are stored in the first bucket 3
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) buckets.add(new ArrayList<>());

        // put into according buckets
        for (int key: countMap.keySet()){
            int val = countMap.get(key);
            buckets.get(val).add(key);
        }

        int index = 0;
        for (int j = buckets.size() - 1; j >= 0 && index < k; j--){
            for (int num: buckets.get(j)){
                res[index++] = num;

                if (index == k){
                    break;
                }
            }
        }
        return res;
    }
}
