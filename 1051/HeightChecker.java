/*
Key Idea:
    Solution 1: Create new sorted array and compare values with
    original array.
    
    Time: O(nlogn)
    Space: O(n)
    
    Solution 2: Counting Sort
    We "sort" the array in O(n) by treating each index, h, as a height and the value
    at each index as the count of students with said height, h.
    
    ex. 
        [1, 1, 4, 2, 1, 3] -> [0, 3, 1, 1, 1]
                               0  1  2  3  4  
        note: the final array would be larger because we initialize it 
        to hold 101 elements. This exploits the problem's constraints to 
        restrict space complexity to O(1).
        
    Afterwards, we just traverse the original array while checking the value
    of the earliest sorted array index. 
    
    If the count sorted array at index, h, has a non-zero value and the original 
    array's current value, v, is equal to h, then there is no mismatch. 
    Value v is where it is supposed to be. Otherwise, if v is not equal to h, then 
    the v is supposed to be somewhere else and we add the count of mismatches.
    
    ex.  
        original array (oa):     [1, 1, 4, 2, 1, 3] 
        count sorted array (csa): [0, 3, 1, 1, 1]
        
        
        1. 
            mismatches = 0
            
             i 
            [1, 1, 4, 2, 1, 3] : oa[]
            [0, 3, 1, 1, 1]    : csa[]
                h 

            match: oa[i] == h and csa[h] > 0
            h - 1 > 0 so we keep h the same
            decrement csa[h]
            increment i
        2. 
            mismatches = 0
            
                i 
            [1, 1, 4, 2, 1, 3] : oa[]
            [0, 2, 1, 1, 1]    : csa[]
                h 

            match: oa[i] == h and csa[h] > 0
            h - 1 > 0 so we keep h the same
            decrement csa[h]
            increment i
        3. 
            mismatches = 0
            
                   i 
            [1, 1, 4, 2, 1, 3] : oa[]
            [0, 1, 1, 1, 1]    : csa[]
                h 

            mismatch: oa[i] != h 
            increment mismatch
            decrement csa[h] and 
            h - 1 = 0 so we increment h
            increment i
        4. 
            mismatches = 1
            
                      i 
            [1, 1, 4, 2, 1, 3] : oa[]
            [0, 0, 1, 1, 1]    : csa[]
                   h 

            match: oa[i] == h and csa[h] > 0
            decrement csa[h] and 
            h - 1 = 0 so we increment h 
            increment i
        5. 
            mismatches = 1
            
                         i 
            [1, 1, 4, 2, 1, 3] : oa[]
            [0, 0, 0, 1, 1]    : csa[]
                      h 

            mismatch: oa[i] != h 
            increment mismatch
            decrement csa[h] and
            h - 1 = 0 so we increment h
            increment i
        6. 
            mismatches = 2
            
                            i 
            [1, 1, 4, 2, 1, 3] : oa[]
            [0, 0, 0, 0, 1]    : csa[]
                         h 

            mismatch: oa[i] != h 
            increment mismatch
            decrement csa[h] and
            h - 1 = 0 so we increment h
            increment i
            
            done. return mismatches = 3
            
         This logic is clearer when we "expand" the count sorted array.
         ex.
            original:              [1, 1, 4, 2, 1, 3] 
            count sorted:          [0, 3, 1, 1 ,1] 
                                       1  2  3  4 
            expanded count sorted: [0, 1, 1, 1, 2, 3, 4]
            
         note: count sorted array is just a frequency array, with the index
         in this case being the height
         
         Runtime: O(n) (n to setup up count sort + n to check for mismatches = 2n)
         Space: O(1) (we restrict our array to 101)
*/

class Solution2 {
    public int heightChecker(int[] heights) {
        int[] heightFreq = new int[101];
        for (int i = 0; i < heights.length; ++i) {
            // will be fine because restrictions place vals [1, 100]
            heightFreq[heights[i]] += 1;
        }
        
        int freqWalker = 0;
        int mismatches = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (heightFreq[freqWalker] == 0) {
                freqWalker++;
            }
            
            if (heights[i] != freqWalker) {
                mismatches++;
            }
            
            heightFreq[freqWalker]--;
        }
        
        return mismatches;
    }
}

class Solution1 {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        for (int i = 0; i < heights.length; ++i) {
            expected[i] = heights[i];
        }
        Arrays.sort(expected);
        int outOfPlaceVals = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (heights[i] != expected[i]) {
                outOfPlaceVals++;
            }
        }
        return outOfPlaceVals;
    }
}
