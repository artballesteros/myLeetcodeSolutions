/*
Key Idea:
    Use a while loop to divide and subtract until num reaches zero.
    Keep and count of how many while loop iterations and return it.
    
    Time: O(log n) 
    (worst case, we divide by two and subtract by 1 equally. 2log n or just log n)
    Space: O(1)
*/
class Solution {
    public int numberOfSteps(int num) {
        int numberOfSteps = 0;
        while (num > 0) {
            numberOfSteps++;
            if (num % 2 == 0)
                num /= 2;
            else 
                num--;
        }
        return numberOfSteps;
    }
}

// Uses bitwise operations instead of modulo
class Solution2 {
    public int numberOfSteps(int num) {
        int numberOfSteps = 0;
        while (num > 0) {
            numberOfSteps++;
            if ((num & 1) == 0)
                num >>= 1;
            else 
                num--;
        }
        return numberOfSteps;
    }
}
