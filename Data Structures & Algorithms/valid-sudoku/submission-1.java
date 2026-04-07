class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){

                if(board[row][col] != '.'){
                    String rowAdd = board[row][col] + " found at row " + row;
                String colAdd = board[row][col] + "found at column " + col;
                String boxAdd = board[row][col] + " found at box " + row/3 + " " + col/3;

                if(!seen.add(rowAdd) || !seen.add(colAdd) || !seen.add(boxAdd)){
                    return false;
                }

                }
            }
        }

        return true;
        
    }
}
