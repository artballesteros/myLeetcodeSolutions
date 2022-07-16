/**
Key Idea:
    Use two stacks, one normal stack to hold values as usual and another
    'min_stack' to keep track of the mininum value at the time we pushed
    a new value onto the normal stack. The stack sizes should be the same
    because every value in the normal stack is tied to a min_value in the 
    min_stack. 

    ex.
    Input:   1, 2, 3, 1, -1, -9, 10
    stack:   1, 2, 3, 1, -1, -9, 10  (top)
    m_stack: 1, 1, 1, 1, -1, -9, -9. (top)

    Setting up two stacks in this way makes it easy to 
    create O(1) operations since we can just use the built-in
    stack operations to pop each value in order together!

    It costs us O(2n) space however. Not too different from a normal stack.
    Implementing one using a linked list would still cost us O(2n) space,
    though it would probably be lighter and faster due to cutting down the
    fat found in stacks.
*/

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min_stack;
    
    public MinStack() {
        this.stack = new Stack<>();
        this.min_stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
        if (min_stack.empty() || val < min_stack.peek())
            min_stack.push(val);
        else 
            min_stack.push(min_stack.peek());
    }
    
    public void pop() {
        stack.pop();
        min_stack.pop();
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}

