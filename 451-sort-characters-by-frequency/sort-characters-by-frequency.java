class Solution {
    public String frequencySort(String s) {
        HashMap<Character , Integer > map = new HashMap<>();

        for(int i = 0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c , 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        //sort the list
        list.sort((a,b) -> b.getValue() - a.getValue() );//in descending order (for doing in ascending order do a.getValue() - b.getValue())
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character , Integer> entry: list) {
            char c = entry.getKey();
            int freq = entry.getValue();
            for(int i = 0 ; i<freq ; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}