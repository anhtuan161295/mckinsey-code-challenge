package com.mckinsey.substringsearch;

import java.util.*;
import java.util.stream.Collectors;

public class Result {

    /*
     * Complete the 'findSubstrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    // brute force solution
    public static int findSubstrings(String s) {
        // Write your code here
        // a list to store all subStrings with length = 1
        List<String> oneCharList = new ArrayList<>();

        // a list to store all subStrings with length > 1
        List<String> multipleCharList = new ArrayList<>();
        int len = s.length();
        // Iterate over all the subStrings
        for (int i = 0; i < len; ++i) {

            oneCharList.add(String.valueOf(s.charAt(i)));
            int left = i - 1;
            int right = i + 1;

            while (left >= 0) {
                String subStr = s.substring(left, i);
                multipleCharList.add(subStr);
                left--;
            }

            while (right <= len) {
                String subStr = s.substring(i, right);
                multipleCharList.add(subStr);
                right++;
            }
        }

        multipleCharList.removeAll(oneCharList);
        // a list to store all subStrings with length > 1 and non repeating characters
        Set<String> multipleCharListV2 = new HashSet<>();

        for (String subStr : multipleCharList) {
            Set<Character> characterSet = new LinkedHashSet<>();

            for (int i = 0; i < subStr.length(); i++) {
                while (!characterSet.add(subStr.charAt(i))) {
                    characterSet.remove(characterSet.iterator().next());
                }
            }

            String newSubStr = characterSet.stream().map(i -> i.toString()).collect(Collectors.joining());
            multipleCharListV2.add(newSubStr);
        }

        return oneCharList.size() + multipleCharListV2.size();
    }

    // optimized 1
    public static int findSubstringsV2(String s) {
        // a list to store all subStrings with length = 1
        List<String> oneCharList = new ArrayList<>();

        // a set to store all subStrings with length > 1
        Set<String> multipleCharList = new HashSet<>();
        int len = s.length();
        // Iterate over all the subStrings
        for (int i = 0; i < len; ++i) {

            oneCharList.add(String.valueOf(s.charAt(i)));
            // we want to find a substring with length >= 2
            int left = i;
            int right = i + 2;

            while (right <= len) {
                String subStr = s.substring(left, right);
                multipleCharList.add(subStr);
                right++;
            }
        }

        // a list to store all subStrings with length > 1 and non repeating characters
        Set<String> multipleCharListV2 = new HashSet<>();

        for (String subStr : multipleCharList) {
            Set<Character> characterSet = new LinkedHashSet<>();

            for (int i = 0; i < subStr.length(); i++) {
                while (!characterSet.add(subStr.charAt(i))) {
                    characterSet.remove(characterSet.iterator().next());
                }
            }

            String newSubStr = characterSet.stream().map(i -> i.toString()).collect(Collectors.joining());
            multipleCharListV2.add(newSubStr);
        }

        return oneCharList.size() + multipleCharListV2.size();
    }

    public static void main(String[] args) {
        int result = Result.findSubstringsV2("bcada"); // 12
        System.out.println(result);

//        int result2 = Result.findSubstringsV2("abcd"); // 10
//        System.out.println(result2);
    }
}
