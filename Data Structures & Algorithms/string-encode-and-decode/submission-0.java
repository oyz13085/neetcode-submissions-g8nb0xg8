
class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            // Append length + delimiter + the actual string
            encoded.append(s.length()).append("#").append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            // 1. Find where the delimiter is
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            
            // 2. Parse the length from the characters before the '#'
            int length = Integer.parseInt(str.substring(i, j));
            
            // 3. Move i to the start of the actual string content
            i = j + 1;
            
            // 4. Extract the string using the length we found
            result.add(str.substring(i, i + length));
            
            // 5. Move i to the start of the next "Length" section
            i += length;
        }
        
        return result;
    }
}