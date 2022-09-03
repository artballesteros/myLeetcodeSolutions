/*
Key Idea:
    We compare values between both arrays starting with the last
    values of both list. We fill the num1 array starting at the 
    true end. Old data is overwritten.
    
    1.
        1 2 3 0 0 0
            ^     *
        2 5 6
            ^
    2.
        1 2 3 0 0 6
            ^   *
        2 5 6
          ^
    3.
        1 2 3 0 5 6
            ^ *
        2 5 6
        ^
    4.
        1 2 3 3 5 6
          ^ *
        2 5 6
        ^
    5.
        1 2 2 3 5 6
        ^ *
        2 5 6
        ^
    6.
        1 2 2 3 5 6
        ^
        *
        2 5 6
       ^
       
    Runtime: O(n + m)
    Space: O(1)
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int back = m + n - 1;
        int end1 = m - 1;
        int end2 = n - 1;
        while (end1 >= 0 && end2 >= 0) {
            if (nums1[end1] >= nums2[end2]) {
                nums1[back] = nums1[end1];
                end1--;
            } else {
                nums1[back] = nums2[end2];
                end2--;
            }
            back--;
        }
        
        while (end1 >= 0) {
            nums1[back] = nums1[end1];
            back--;
            end1--;
        }
        
        while (end2 >= 0) {
            nums1[back] = nums2[end2];
            back--;
            end2--;
        }
    }
}
