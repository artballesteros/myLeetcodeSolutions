/*
Key Idea:
    Use a hashmap to map the characters in the magazine with a count of
    said character.
    
    Subtract one from count any time a character is used in the ransom
    note. If we find a character the magazine doesn't have or we run
    out of characters, return false.
    
    Time: O(n + m) (n ransomNote length and m magazine length)
    Space: O(1) (hashmap size is restricted to 26; 26 unique characters possible)
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < magazine.length(); ++i) {
            char currChar = magazine.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }
        
        for (int j = 0; j < ransomNote.length(); ++j) {
            char currChar = ransomNote.charAt(j);
            int charCount = map.getOrDefault(currChar, 0);
            if (charCount > 0)
                map.put(currChar, --charCount);
            else
                return false;
        }
        return true;
    }
}
