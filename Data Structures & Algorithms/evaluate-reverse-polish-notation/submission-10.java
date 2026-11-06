class Solution {
    public int evalRPN(String[] tokens) {
        // stack to perform arithmetic in order
        // perform operation after symbol is 
        // push 2 numbers t stack

        Stack<Integer> stack = new Stack<>();
        int num1 = 0;
        int num2 = 0;

        if (tokens.length < 0 ){
            return 0;
        }

        for (int i = 0; i < tokens.length; i++){
            switch(tokens[i]){
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                default: // given a number push it to the stack
                    stack.push(Integer.parseInt(tokens[i]));
                
            }
        }
        return stack.pop();

        
    }
}
