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

/*
A much prettier solution. Exploits the pattern:
    1          return 1
    1 2        return 2
    1 2 3      return 2
    1 2 3 4    return 3
    1 2 3 4 5  return 3
    etc.
    
    The middle stays the same for two values (usually)
    so every two jumps, we move the middle once.
    
    *Key Idea*: Always try to find patterns. Create your own test cases
    if you have to and start small.
*/
class Solution2 {
    public ListNode middleNode(ListNode head) {
        ListNode middle = head;
        ListNode end = head;
        while (end != null && end.next != null) {
            middle = middle.next;
            end = end.next.next;
        }
        return middle;
    }
}
