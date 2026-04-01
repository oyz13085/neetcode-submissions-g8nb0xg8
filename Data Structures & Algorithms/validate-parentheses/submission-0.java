class Solution {
    public boolean isValid(String s) {
        char[] characters = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        String open = "({[";

        for(char character:characters){
            if(open.contains(String.valueOf(character))){
                stack.push(character);
            }else{
                
                if (stack.isEmpty()) return false;
                
                char top = stack.pop(); // Pop ONCE and save it
                
                if (character == ')' && top != '(') return false;
                if (character == '}' && top != '{') return false;
                if (character == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}