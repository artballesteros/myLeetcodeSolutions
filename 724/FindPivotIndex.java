/*
[easy]
Key Idea:
    We will traverse the array and keep track of the left and right
    sums as we move from the left to right. Left sum is equal to 
    zero and right sum would equal total minus current value. 
    
    We keep adding the current value to the left sum and subtracting
    current value from the right sum. 
    
    Eventually, we may find an index where the left and right sums
    are equal. Very simple algorithm.
    
    Time: O(n)
    Space: O(1)
*/

class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        
        // find sum of all elements
        for (int i = nums.length - 1; i >= 0; --i) {
            rightSum += nums[i];
        }
        
        // find index where rightSum and leftSum are equal
        for (int j = 0; j < nums.length; ++j) {
            // substract current value to find true rightSum
            rightSum -= nums[j];
            if (leftSum == rightSum) {
                return j;
            }
            // update leftSum for next loop
            leftSum += nums[j];
        }
        
        return -1;
    }
}
