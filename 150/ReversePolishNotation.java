/**
Key Idea:
    The idea here is to use a stack to keep track of the numbers and pop two
    at a time to perform the correct arithmetic whenever a token is an 
    operator. So push operands until you come accross an operator and then
    pop operators to perform correct math (I used a switch statement for this).
    
    Since the strings are valid, I don't have to worry about the case where
    the array only contains operators, operands or is empty.
    
    The runtime is O(n) since we have to iterate through the entire input
    array. The space complexity is O(m). We never push operators onto
    our stack so it's size would only equal the input arrays size when there
    is only a single integer in the array and stack (valid expression).
    
    m <= n
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            
            int num2 = stack.pop();  
            int num1 = stack.pop();

            switch(token) {
                case "+":
                    stack.push(num1 + num2);
                    break;
                case "-":
                    stack.push(num1 - num2);
                    break;
                case "*":
                    stack.push(num1 * num2);
                    break;
                case "/":
                    stack.push(num1 / num2);
                    break;
            }
        }
        
        return stack.pop();
    }
}
