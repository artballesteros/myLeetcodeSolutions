/*
Key Idea:
    The key idea here is that if there was a cycle than two pointers
    traveling along the linked list will eventually reach each other.
    
    If a pointer reaches null, than that means that the singly linkedlist
    has no cycles.
    
    Space: O(1)
    Time: O(n)
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            runner = runner.next.next; 
            head = head.next;
            
            if (head == runner)
                return true;
        }
        
        return false; 
    }
}
