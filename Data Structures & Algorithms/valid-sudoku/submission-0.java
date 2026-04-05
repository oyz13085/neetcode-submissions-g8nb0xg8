class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char number = board[r][c];

                if(number != '.'){
                    String rowKey = board[r][c] + " in row " + r;
                    String colKey = board[r][c] + " in col " + c;
                    String boxKey = board[r][c] + " in box " + r/3 + "" + c/3;

                    if(!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)){
                        return false;
                    }
                }
            
                
            }
        }
        return true;
    }
}
