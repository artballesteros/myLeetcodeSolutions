/*
Key Idea:
    The idea is cut out the digits of x one by one. Ensure they are
    in their correct positions by multiplying the answer by 10 
    repeatedly for each digit. You can check that your reversed x is not going
    to overflow by checking that the current reversed x value
    isn't larger than the MAX_VALUE/10. If it is larger, that means
    that multiplying reverse_x by 10 will have it's value jump over
    2^31-1 (max value of an signed integer).
    
    Runtime: O(n) where n is the length of the integer x
    Space: O(1)
*/
class Solution {
    public int reverse(int x) {
        int reversed_x = 0;
        int curr = Math.abs(x);
        while (curr > 0) {
            if (reversed_x > Integer.MAX_VALUE/10) {
                return 0;
            }
            reversed_x *= 10;
            reversed_x += curr % 10;
            curr /= 10;
        }
        return x > 0 ? reversed_x : -reversed_x;
    }
}
