class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int right=0;right<=heights.length;right++){
            int currentHeight = (right == heights.length) ? 0 : heights[right];

            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int mid = stack.pop();
                int width = 0;

                if(stack.isEmpty()){
                    width = right;
                }else{
                    width = right - stack.peek() - 1;
                }

                int area = heights[mid] * width;
                maxArea = Math.max(maxArea,area);
            }

            stack.push(right);
        }
        
        return maxArea;
    }
}
