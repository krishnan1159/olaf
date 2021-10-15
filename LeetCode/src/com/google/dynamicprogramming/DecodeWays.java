package com.google.dynamicprogramming;

import java.io.IOException;
import java.util.Arrays;

public class DecodeWays {

    private static int numDecodingsInternal(final String input, final int pos, final int[] numDecodings) {
        if (pos >= input.length()) {
            return 1;
        }

        if (numDecodings[pos] != -1) {
            return numDecodings[pos];
        }

        int res = 0;

        // Check if we can take the current char.
        char currentChar = input.charAt(pos);
        if (isValid(currentChar, ' ')) {
            res = numDecodingsInternal(input, pos + 1, numDecodings);
        }

        // check if we can take two chars consecutively
        if ((pos + 1) < input.length() ) {
            char nextChar = input.charAt(pos + 1);

            if (isValid(currentChar, nextChar)) {
                res += numDecodingsInternal(input, pos + 2, numDecodings);
            }
        }

        numDecodings[pos] = res;

        return res;
    }

    private static boolean isValid(char firstChar, char secondChar) {
        if (firstChar == '0' || (secondChar != ' ' && firstChar > '2')) {
            return false;
        }

        if ((firstChar == '2' && secondChar > '6')) {
            return false;
        }

        return true;
    }

    private static int numDecodings(String input) {
        int[] numDecodings = new int[input.length()];
        Arrays.fill(numDecodings, -1);
        return numDecodingsInternal(input, 0, numDecodings);
    }

    public static void main(String[] args) throws IOException {
        final String input = "1";
        System.out.println("Result = " + numDecodings(input));
    }
}
