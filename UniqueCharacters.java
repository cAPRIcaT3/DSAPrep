import java.util.Arrays;

public class UniqueCharacters {
    //Binary Search Method
    public static int binarySearch(char[] arr, char target, int start, int end){
        while (start <= end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target){
                return mid;
            }
            if (arr[mid] < target){
                start = mid + 1;
            }
            else {
                end  = mid - 1;
            }
        }
        return - 1;
    }
    

    //method to check if the characters are unique
    public static boolean isUnique(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
    
    //Check each character using BinarySearch
    for (int i = 0; i< chars.length; i++){
        if (binarySearch(chars, chars[i], i+1, chars.length - 1)!= -1){
            return false;
        }
    }
    return true; //all characters are unique
    }

    public static void main(String[] args){
        String test = "abcdefg";
        System.out.println("Does the string \" " + test + "\"have all unique characters?" + isUnique(test));

        String test2 = "hello";
        System.out.println("Does the string \" " + test2 + "\"have all unique characters?" + isUnique(test2));
    }
}
