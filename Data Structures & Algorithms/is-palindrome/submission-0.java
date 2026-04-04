class Solution {
    public boolean isPalindrome(String s) {
        char[] characters = s.toCharArray();
        int left = 0;
        int right = characters.length -1;

        while(left <= right){
            if(Character.isLetterOrDigit(characters[left]) && Character.isLetterOrDigit(characters[right])){
                if(Character.toLowerCase(characters[left])!=(Character.toLowerCase(characters[right]))){
                    return false;
                }
                left++;
                right--;
            }else{
                if(!Character.isLetterOrDigit(characters[left])){
                    left++;
                }

                if(!Character.isLetterOrDigit(characters[right])){
                    right--;
                }
            }
        }

        return true;
        
    }
}
