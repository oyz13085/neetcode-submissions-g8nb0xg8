class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int numRow = matrix.length;
        int numCol = matrix[0].length;
        int right = numRow * numCol - 1;

        while(left<=right){
            int mid = left + (right-left)/2;
            int row = mid/numCol;
            int col = mid%numCol;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return false;
        
    }
}
