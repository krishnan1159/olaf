package com.google.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int lengthOfLongestSubstring(String s) {
        final Map<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
        int startIndex = 0, maxLength = -1;
        for (int index = 0; index < s.length(); index++) {
            char currentChar = s.charAt(index);

            if (charIndexMap.containsKey(currentChar)) {
                int charPos = charIndexMap.get(currentChar);
                int localMaxLength = index - startIndex;
                if (localMaxLength > maxLength) {
                    maxLength = localMaxLength;
                }
                if ((charPos + 1) > startIndex) {
                    startIndex = charPos + 1;
                }
            }

            // Update the map with character position
            charIndexMap.put(currentChar, index);
        }

        if ((s.length() - startIndex) > maxLength) {
            maxLength = (s.length() - startIndex);
        }
        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        //Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Reading data using readLine
        String[] input = {"abcabcbb", "abcdab", "abcdaebcb", "a", "ab", "abc", "abba", "abcabcbb"};
        for (int i = 0; i < input.length; i++) {
            System.out.print("Proccessing input :: " + input[i] + ",");
            System.out.println(lengthOfLongestSubstring(input[i]));
        }
    }
}
