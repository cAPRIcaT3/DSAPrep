public class URLify {
    public static void urlify(char[] str, int trueLength) {
        int spaceCount = 0;
        int index;
        int i;

        // First, count the number of spaces within the true length
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        // Calculate the new length
        index = trueLength + spaceCount * 2;

        // Start replacing spaces from the end of the string
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        String str = "Mr John Smith   "; // The last 3 spaces are for the extra characters
        int trueLength = 13;

        // The correct length should be trueLength + spaceCount * 2
        // Calculate the number of spaces within the true length
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        // Allocate a char array with enough space to hold the final string
        char[] charArray = new char[trueLength + spaceCount * 2];
        System.arraycopy(str.toCharArray(), 0, charArray, 0, trueLength);

        // Call the urlify method
        urlify(charArray, trueLength);

        // Print the modified character array as a string
        System.out.println("\"" + new String(charArray) + "\"");
    }
}
