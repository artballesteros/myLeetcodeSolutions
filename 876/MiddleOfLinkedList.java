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
/*
Key Idea:
    We use a dummy node to determine the length of the linkedList.
    Afterwards, the traverse the linkedlist from the head
    half the previous length.
    
    If the original length is even, we can just return the node
    we land on. Otherwise, we move the dummy one more to the right
    to capture the second middle node and return it.
    
    The parity of the length matters.
    Even: return middle as you would expect
    Odd: return second middle ('Even' middle's next node)
    
    Time: O(n) (we traverse the list no more than n + n/2 + 1)
    Space: O(1)
*/
class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode dummy = new ListNode(0, head);
        while (dummy != null) {
            length++;
            dummy = dummy.next;
        }
        
        int size = length;
        length /= 2;
        dummy = new ListNode(0, head);
        while (length-- > 0) {
            dummy = dummy.next;
        } 
        
        // using bitmask to check parity
        if ((size & 1) != 0)
            dummy = dummy.next;
            
        return dummy;
    }
}
