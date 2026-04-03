class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> id = new HashMap<>();

        for(String word:strs){
            char[] character = word.toCharArray();
            Arrays.sort(character);
            String sortedKey = String.valueOf(character);
            
            id.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(id.values());

        
    }
}
