/*
Key Idea: 
    First Solution:
    Exploits the range of values inputed. Just check if 
    number is within a certain range and return appropriate
    length.
    
    Time: O(n)
    Space: O(1)
    
    Second Solution: (probably the one leetcode wants)
    Find length of number by repeatedly dividing by 10.
    Then check if it's even.
    
    Time: O(nm) (n length of input array, m largest length of numbers)
    Space: O(1)
*/
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (numLength2(num) % 2 == 0)
                count++;
        }
        return count;
    }
    
    public int numLength(int num) {
        if (num <= 9)
            return 1;
        if (num <= 99)
            return 2;
        if (num <= 999)
            return 3;
        if (num <= 9999)
            return 4;
        if (num <= 99999)
            return 5;
        return 6;
    }
    
    public int numLength2(int num) {
        int length = 0;
        while (num > 0) {
            num /= 10;
            length++;
        }
        return length;
    }
}
