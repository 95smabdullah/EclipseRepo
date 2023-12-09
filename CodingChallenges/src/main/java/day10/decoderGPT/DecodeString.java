package day10.decoderGPT;

public class DecodeString {
    public static int[] decode(String s) {
        int[] result = new int[26];
        int i = 0;

        while (i < s.length()) {
            char currentChar = s.charAt(i++);
            int count = 1;

            // Check for consecutive occurrences count
            if (i < s.length() && s.charAt(i) == '(') {
                i++; // Skip '('
                StringBuilder countBuilder = new StringBuilder();

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    countBuilder.append(s.charAt(i++));
                }

                count = Integer.parseInt(countBuilder.toString());

                // Skip ')'
                i++;
            }

            // Decode character
            int decodedChar;
            if (i < s.length() && s.charAt(i) == '#') {
                decodedChar = Integer.parseInt(s.substring(i - 2, i - 1));
                i++; // Skip '#'
            } else {
                decodedChar = currentChar - '0';
            }

            // Update result array
            result[decodedChar - 1] += count;
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        String encodedString = "2110#(2)";
        int[] result = decode(encodedString);

        // Display result
        for (int i = 0; i < 26; i++) {
            System.out.println((char) ('a' + i) + ": " + result[i]);
        }
    }
}
