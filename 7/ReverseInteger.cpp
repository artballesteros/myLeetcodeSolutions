/*
Key Idea:
    The idea is cut out the digits of x one by one. Ensure they are
    in their correct positions by multiplying the answer by 10 
    repeatedly for each digit. It is easier to treat a negative
    number as positive and then change the sign of the reversed
    integer at the end of it's calculation. Or at least it's neater :).
    We wouldn't have to think about modding negative numbers and 
    checking that the reversed_x isn't less than INT_MIN/10.
    
    You can check that your reversed_x is not going
    to overflow by checking that the current reversed x value
    isn't larger than the INT_MAX/10. If it is larger, that means
    that multiplying reverse_x by 10 will have it's value jump over
    2^31-1 (max value of a signed integer).
    
    ex. -123
    
    1: x = -123 -> curr = 123, reversed_x = 0
    [START LOOP]
    2: curr = 123 -> curr = 12, reversed_x = 3
    3: curr = 12 -> curr = 1, reversed_x = 32
    4: curr = 1 -> curr = 0, reversed_x = 321
    [STOP LOOP]
    5. determine sign of reversed_x by checking if
       original x is greater than zero.
    6. return reversed_x
    
    Runtime: O(n) where n is the length of the integer x
    Space: O(1)
*/
class Solution {
public:
    int reverse(int x) {
        int curr_value = abs(x);
        int reversed_value = 0;
        while (curr_value > 0) {
            if (reversed_value > INT_MAX/10)
                return 0;
            reversed_value *= 10;
            reversed_value += curr_value % 10;
            curr_value /= 10;
        }
        return x > 0 ? reversed_value : -reversed_value;
    }
};
