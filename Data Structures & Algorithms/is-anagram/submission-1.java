class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        char[] word1 = s.toCharArray();
        HashMap<Character,Integer> freq = new HashMap<>();

        for(char word: word1){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }


        char[] word2 = t.toCharArray();

        for(char word: word2){
            freq.put(word,freq.getOrDefault(word,0)-1);
            if(freq.get(word)==-1){
                return false;
            }
        }
        return true;

        
    }
}
