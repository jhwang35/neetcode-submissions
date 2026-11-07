class Solution {
    public int evalRPN(String[] tokens) {
        // stack to store numbers 
        // there should be at least two numbers on the stack at all times
        // if we encounter an operation take the top 2 numbers
        // store the result back onto the stack so we can perform operations to that number

        Stack<Integer> stack = new Stack<>();
        int num1 = 0;
        int num2 = 0;

        if (tokens.length == 0){
            return 0;
        }

        for (String token : tokens){
                if (token.equals("+")){
                    stack.push(stack.pop() + stack.pop());
                }
                else if (token.equals("-")){
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                }
                else if (token.equals("*")){
                    stack.push((stack.pop() * stack.pop()));
                }
                else if (token.equals("/")){
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                }
                else{ // push our number to stack
                    stack.push(Integer.parseInt(token));
                }
        }
        
        return stack.pop();
        
    }
}
