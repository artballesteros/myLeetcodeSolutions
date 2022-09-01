/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
Key Idea:
    Use three pointers, two to connect two nodes in reverse order and another
    to keep track of the rest of the linked list.
    
    Ex. 
            1 -> 2 -> 3 -> 4 -> null
            ^    ^    ^
            f    m    b
     
    null <- 1 <- 2    3 -> 4 -> null
            ^    ^    ^
            f    m    b
            
    null <- 1 <- 2    3 -> 4 -> null
                 ^    ^    ^
                 f    m    b
                 
    null <- 1 <- 2 <- 3    4 -> null
                 ^    ^    ^
                 f    m    b
                 
    null <- 1 <- 2 <- 3    4 -> null
                      ^    ^    ^
                      f    m    b
                      
    null <- 1 <- 2 <- 3 <- 4    null
                      ^    ^    ^
                      f    m    b
                      
    null <- 1 <- 2 <- 3 <- 4    null
                           ^    ^ 
                           f    mb
                           
    We stop here because middle pointer (m)
    is null. Return front (f) pointer as new
    head;
    
    Time: O(n)
    Space: O(1)
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode front = head;
        ListNode middle = front.next;
        ListNode back = middle.next;
        
        while (middle != null) {
            if (front == head)
                front.next = null;
                
            middle.next = front;
            front = middle;
            middle = back;
            if (back != null)
                back = back.next;
        }
        
        return front;
    }
}

/**
Key idea:
    Use a stack to store nodes in reverse order. Afterwords, pop
    them off and have them point to the new top of the stack. Last
    remaining listnode will point to null.
    
    Runtime: O(n)
    Space: O(n)
    
    Note: We can probably use recursion to solve this problem
    as well.
*/

class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        
        head = stack.peek();
        while (!stack.empty())
            stack.pop().next = stack.size() >= 1 ? stack.peek() : null;
        
        return head;
    }
}
