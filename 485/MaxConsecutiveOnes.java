/*
Key Idea:
    Keep two counts, one of keeping track of ones and another keeping
    track of max ones. Check if current count is greater than curr
    max for every new one found.
    
    Time: O(n)
    Space: O(1)
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }
}
