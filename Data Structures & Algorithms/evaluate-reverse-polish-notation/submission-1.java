class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token:tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();

                int answer;
                switch(token){
                    case "+":
                        answer = num1 + num2;
                        stack.push(answer);
                        break;
                    case "-":
                        answer = num1 - num2;
                        stack.push(answer);
                        break;
                    case "*":
                        answer = num1 * num2;
                        stack.push(answer);
                        break;
                    case "/":
                        answer = num1 / num2;
                        stack.push(answer);
                        break;            
                }
                
            }else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
