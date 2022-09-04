/*
Key Idea:
    1. find a peak
    2. check that the peak is within the array ends
    3. check that the left of the peak is increasing
    4. check that the right of the peak is decreasing
    
    Runtime: O(n) (2(n-1) -> n)
    Space: O(1)
*/
class Solution {
    public boolean validMountainArray(int[] arr) {
        // find a peak
        int peak = 0;
        for (int i = 1; i < arr.length; ++i) {
            peak = i;
            if (arr[i] < arr[i - 1]) {
                peak = i - 1;
                break;
            }
        }
        
        // check that the peak isn't at the array ends
        if (peak == arr.length - 1 || peak == 0) {
            return false;
        }
        
        // check that left of peak is only increasing
        for (int i = 1; i <= peak; ++i) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        
        // check that right of peak is only decreasing
        for (int i = peak + 1; i < arr.length; ++i) {
            if (arr[i] >= arr[i - 1]) {
                return false;
            }
        }
        
        return true;
    }
}
