/*
[medium]
Key Idea:
    Keep track of the previous length of consecutive ones that include
    the previous zero found. Once a new zero is found, subtract the current
    length by the previous length and then update the previous length
    with the current length. 
    
    Every time you cut the current length, check to see if it's larger
    than the current max.
    
    This strategy ensures that our subarray of consecutive ones always
    only includes at most one zero because we get rid of the length of 
    the whole subsection before the previous zero.
    
    This is easier to visualize. 
    
    1. 
          1 1 1 0 1 1 0 1 1
        ^       ^ 
        p       c 
        prev length = 0
        curr length = 4 - 0 (curr - prev)
        prev length = 4 (update)
    
    2. 
          1 1 1 0 1 1 0 1 1
                ^     ^ 
                p     c
        prev length = 4
        curr length = 7 - 4 (curr - prev)
        prev length = 3 (update)
        
     etc.
     
     Not really a two pointer approach but you could think 
     of it as such...
     
     Time: O(n)
     Space: O(1)

     Note: this also works for the stream follow-up question.
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currLength = 0;
        int prevLength = 0;
        for (int walker = 0; walker < nums.length; ++walker) {
            currLength++;
            if (nums[walker] == 0) {
                currLength -= prevLength;
                prevLength = currLength;
            }
            max = currLength > max ? currLength : max;
        }
        return max;
    }
}
