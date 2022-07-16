/**
Key Idea:
    Move a pointer in the front and a pointer in the back until we
    reach first alphanumeric character. If both aren't equal, return
    false. Otherwise, increment head and decrement tail to continue;
    
    It is much easier and more efficient to convert the string's capital letters
    into lowercase before calling the while loop.
    
    Runtime: O(n) (we don't visit each character more than once)
    Space: O(1) (no data structures created)
*/
    
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int head = 0;
        int tail = s.length() - 1;
        
        while (head < tail) {
            while (!isAlphanumeric(s.charAt(head)) && head < tail)
                head++;
            
            while (!isAlphanumeric(s.charAt(tail)) && head < tail) 
                tail--;
            
            if (!(s.charAt(head) == s.charAt(tail)))
                return false;
            
            head++;
            tail--;
        }
        
        return true;
    }
    
    public boolean isAlphanumeric(char c) {
        boolean check = (c >= 'a' && c <= 'z') 
            || (c >= '0' && c <= '9') 
            || (c >= 'A' && c <= 'Z');
        
        return check;
    }
}
