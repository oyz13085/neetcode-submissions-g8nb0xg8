class Solution {
    public boolean isAnagram(String s, String t) {
        char[] word1 = s.toCharArray();
        char[] word2 = t.toCharArray();

        if(word1.length != word2.length){
            return false;
        }

        HashMap<Character,Integer> freq = new HashMap<>();

        for(char word:word1){
            freq.put(word,freq.getOrDefault(word,0) + 1);
        }

        for(char word:word2){
            if(!freq.containsKey(word)){
                return false;
            }

            if(freq.get(word) == 0){
                return false;
            }else{
                freq.put(word,freq.get(word)-1);
            }
        }
        return true;
    }
}
