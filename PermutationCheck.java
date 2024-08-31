import java.util.HashMap;

public class PermutationCheck{
    public static boolean arePermutations(String str1, String str2){
        // if lengths are not equal, they cannot be permutations
        if (str1.length() != str2.length()){
            return false;
        }

        // create a character frequency map for the first string
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Count the frequency of each character in str1
        for(char c: str1.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Decrease the frequency based on str2
        for(char c: str2.toCharArray()){
            if (!charCountMap.containsKey(c) || charCountMap.get(c) == 0) {
                return false; // More occurrences of c in str2 than in str1, or c not in str1
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
        }

        // if all counts are zero, the strings are permutations of each other
        return true;
    }

    public static void main(String[] args){
        String str1 = "abcde";
        String str2 = "edcba";
        String str3 = "cdbae";
        String str4 = "cdcde";
    
        if(arePermutations(str1, str2)){
            System.out.println(str1 + " and " + str2 + " are permutations of each other.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not permutations of each other.");
        }
        
        if(arePermutations(str3, str4)){
            System.out.println(str3 + " and " + str4 + " are permutations of each other.");
        } else {
            System.out.println(str3 + " and " + str4 + " are not permutations of each other.");
        }
    }
}

/*companion explanation

- str1.toCharArray() : This method converts the strings 'str1' into an array of characters
For exmaple, if 'str1' is 'abcde', it becomes
['a', 'b', 'c', 'd', 'e']

- for(char c: str1.toCharArray())': This is a "for-each" loop that iterates over
each character 'c' in the array returned by 'toCharArray()'.

'charCountMap.put(c, charCountMap.getOrDefault(c,0) + 1)':

    - charCountMap is a HashMap where the key is a character ('c'), and the value is an
      integer representing the count of that character.

    - charCountMap.getOrDefault(c,0) : This retrieves the current count of 'c' from the
      charCountMap. If 'c' is not yet in the map, it returns '0' (the default value)
    
    - charCountMap.put(c, charCountMap.getOrDefault(c,0) + 1): This increments the count
      of the character 'c'by 1 and puts it back in the map.
      
Watch out for:
Understanding the getOrDefault Method:It's a convenience method that avoids checking whether a key exists in the map before getting its value.
*/