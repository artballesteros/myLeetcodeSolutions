/*
Key Idea:
    The key idea is too walk along each list and compare the node values
    one at a time. We instantiate a new head to eventually return
    and connect the appropriate nodes as we walk along both lists.
    
    We need to check if the input lists are empty (null) and
    since the size of the lists aren't always equal, we will 
    need to append the remaining nodes to the end of the merged
    sublist. 
    
    This has an O(n) time complexity (n = number of nodes) 
    and O(1) space (we use the given nodes to construct our
    merged list and we only create one new node).
*/

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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        
        if (list2 == null) {
            return list1;
        }
        
        ListNode head;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        
        ListNode dummy = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = list1; 
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        
        if (list1 != null) {
            dummy.next = list1; 
        }
        
        if (list2 != null) {
            dummy.next = list2;
        }
        
        return head;
    }
}
