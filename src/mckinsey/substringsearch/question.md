## 2. Substring Search
Given a string, how many different substrings exist in it that have no repeating characters? Two substrings are considered different if they have a different start of end index.

Example:
s = "abac"

The substrings that have no repeating characters in them are "a", "b", "c", "ab", "ba", "ac" and "abc". Note that "aba" and "abac" do not qualify because the character 'a' is repeated in them. Also note that two substrings, "a" and "a", both qualify because their start indices are different: s[0] and s[2]. There are 8 substrings that have no repeating characters.

**Function Description**  
Complete the function findSubStrings in the editor below.

_findSubstrings_ has the following parameter:  
string s: the given string  
**Returns**  
int: the number of substrings in s that have no repeating characters

**Constraints**
- 1 <= length of s <= 10^5
- s consists of only lowercase English letters, ascii['a'-'z']

**Sample Case 0**  
Sample Input : bcada  
Sample Output: 12  
Explanation: There are 12 substrings in "bcada" that have no repeating characters: "b", "c", "a", "d", "a", "bc", "ca", "ad", "da", "bca", "cad", and "bcad".

**Sample Case 1**  
Sample Input : abcd  
Sample Output: 10  
Explanation: There are 10 substrings in "abcd" that have no repeating characters: "a", "b", "c", "d", "ab", "bc", "cd", "abc", "bcd", and "abcd".


