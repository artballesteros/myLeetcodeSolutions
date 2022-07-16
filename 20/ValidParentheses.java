/** 
Key idea:
    The idea here is to use a stack to hold the opening braces and
    then, as we iterate through the input string, we check if the 
    current character (brace) is a complementary brace for the 
    current top of the stack. If the string is a valid one, by the
    end of the for loop, we will have an empty stack. 
    
    A stack does a good job at keeping track of nesting. I think
    this is what makes so useful when solving this problem. We
    used a hashmap to keep track of complementary braces. 
    
    The runtime for this method is O(n), largely because we have to
    iterate through the input string to check validity. Stack and
    hashmap methods are O(1) so we don't have to worry about them.
    The space complexity would be O(n). In the worst case, size
    of the stack would reach the size of the input string. 
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> braces = new Stack<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for (int i = 0; i < s.length(); ++i) {
            char brace = s.charAt(i);
            
            if (braces.empty()) {
                braces.push(brace); 
                continue;
            }
                
            if (braces.peek() == map.get(brace)) {
                braces.pop();
            } else {
                braces.push(brace);
            }
        }
        
        return braces.empty();
    }
}
