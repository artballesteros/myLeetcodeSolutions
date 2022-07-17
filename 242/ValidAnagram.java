/**
Key Idea:
    For two strings to be anagrams:
        1. they must be the same size
        2. each character must exist in the same numbers 
           within both strings
           
    ex. 
        aabcc       bcaca
        a | 2       a | 2
        b | 1       b | 1
        c | 2       c | 2
        
    We can use a hashmap to map the characters to the 
    count of characters found in each string. The 
    counts should be equal, otherwise the strings
    are not anagrams.
    
    Since we are only worrying about lowercase english 
    characters, we can restrict the size of the hashmap
    to 26. 
    
    Space Complexity: O(1)
    
    Since we have to iterate through each string, this 
    method has linear runtime. 
    
    Time Complexity: O(s + t)
    
    For the case where I also have to consider Unicode
    characters, I wouldn't restrict the size of the
    hashmap to 26, so the new space complexity would
    also be linear, O(s + t), 
*/

class Solution {
    private final static int ALPHABET_SIZE = 26;
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        Map<Character, Integer> map = new HashMap<>(ALPHABET_SIZE); 
        for (char cs : s.toCharArray())
            map.put(cs, map.getOrDefault(cs, 0) + 1);
        
        for (char ct : t.toCharArray())
            map.put(ct, map.getOrDefault(ct, 0) - 1);
        
        for (char c : s.toCharArray()) {
            if (map.get(c) != 0)
                return false;
        }
        
        return true;
    }
}
