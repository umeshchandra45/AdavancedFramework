package com.Forsys.ui.actions;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.CharMatcher;

class StringHelper {

    // prevents instantiation of StringHelper
    private StringHelper() {}

    static String RemoveSpecialChars(String input) {
        return input.replaceAll("[^0-9a-zA-Z]", "");
    }

    static String getOnlyEnglishCharsFromString(String input) {
        return input.replaceAll("[^a-zA-Z]", "");
    }

    static boolean isAlpha(String stringToCheck) {
        stringToCheck = stringToCheck.toUpperCase();
        for (int i = 0; i < stringToCheck.length(); i++) {
            int c = (int) stringToCheck.charAt(i);
            if (c < 65 || c > 90)
                return false;
        }

        return true;
    }

    static boolean isNumbers(String str) {
        // check for null or empty
        if (str == null || str.length() == 0)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    static boolean checkIfStringContainsAnyOf(String actualMasterString,
                                              List<String> expectedStringsList) {
        // List<Boolean> assertsList = new ArrayList<Boolean>();
        for (String stringFromList : expectedStringsList) {
            if (actualMasterString.contains(stringFromList))
                return true;
        }
        return false;
    }

    static boolean checkIfStringContainsAllOf(String actualMasterString,
                                              List<String> expectedStringsList,
                                              String failureMsg) {
        // List<Boolean> assertsList = new ArrayList<Boolean>();
        for (String stringFromList : expectedStringsList) {
            if (!actualMasterString.contains(stringFromList))
                return false;
        }
        return true;
    }

    static String stripEverythingBetween(String inputString,
                                         String startString,
                                         String endString) {
        while (inputString.contains(startString) && inputString.contains(endString)) {
            int start = inputString.indexOf(startString);
            int end = inputString.indexOf(endString);
            String stringToRemove = inputString.substring(start, end + endString.length());
            inputString = inputString.replace(stringToRemove, "");
        }
        return inputString;
    }

    static String getEverythingBetween(String inputString,
                                       String startString,
                                       String endString) {
        if (inputString.contains(startString) && inputString.contains(endString)) {
            int start = inputString.indexOf(startString);
            int end = inputString.indexOf(endString);
            return inputString.substring(start, end + endString.length());
        }
        return inputString;
    }

    static void main(String[] a) {
        StringBuilder sb = new StringBuilder("I like strings");
        // char as = 'a';

        for (int i = 0; i < sb.length(); i++) {
            sb.charAt(i);
        }
        int spaceLocations = sb.indexOf(" ");
        sb.replace(spaceLocations, spaceLocations + 1, "*");
        System.out.println(sb.toString());
        // while (spaceLocations != -1) {
        // sb.replace(spaceLocations, spaceLocations, "*");
        // spaceLocations = sb.(" ");
        // }
        // System.out.println(sb.toString());

    }

    static String[] getStringAsArray(String s, String separator) {
        String[] sArray = s.split(separator);
        return sArray;
    }

    static List<String> getStringAsList(String s, String separator) {
        return Arrays.asList(getStringAsArray(s, separator));
    }

    /**
     * Removes all the numerics from the string and returns it.
     *
     * @param str
     * @return String with all numerics stripped off.
     */
    static String stripNumericsFromString(String str) {
        return str.replaceAll("[0-9]", "");
    }

    /**
     * Returns all numbers from the specified string and returns only the numbers as a String.
     *
     * @param str
     * @return String of all numbers extracted from the string str.
     */
    static String getOnlyNumbersFromString(String str) {
        return CharMatcher.javaDigit().retainFrom(str);

    }

    /**
     * Returns all numbers from the specified string. Can be used to retain decimals '.'.
     *
     * @param str
     * @return String of all numbers extracted from the string str.May include decimals ".".
     */
    static String getAllNumbersFromString(String str) {
        return CharMatcher.javaDigit().or(CharMatcher.is('.')).retainFrom(str);
    }

    /**
     * Returns formatted string by substituting the {0} in the mainString with arg.
     * usage:StringHelper.getFormattedString( "Please enter a quantity of {0} or less", "5") will
     * return "Please enter a quantity of 5 or less"
     */
    static String getFormattedString(String mainString, String arg) {
        MessageFormat form = new MessageFormat(mainString);
        String[] args = new String[] {arg};
        return form.format(args);
    }

    /**
     * Returns formatted string by substituting the {0},{1} etc in the mainString with args in the
     * argArray.
     * <p/>
     * 
     * <pre>
     * USAGE: String argArray = {"5", "2"}; StringHelper.getFormattedString("Please enter a quantity
     * of {0} or {1} less", argArray)
     *
     * will return "Please enter a quantity of 5 or 2 less"
     *
     * <pre>
     */
    static String getFormattedString(String mainString, String[] argArray) {
        MessageFormat form = new MessageFormat(mainString);
        return form.format(argArray);
    }

    /**
     * Gets the word at specified position from the passed in sentence.
     * <p>
     * The words in the sentences are separated by single space only.
     * </p>
     *
     * @param sentence from which the word needs to be extracted
     * @param nthWord position of the word which needs to be extracted from the sentence
     * @return the word occurring in nthWord position in the sentence.
     */
    static String getWordFromString(String sentence, int nthWord) {
        String[] words = sentence.trim().split(" ");
        return words[nthWord - 1];
    }

    /**
     * Usage: String imidExpected = UrlParser.substring(url, "_imid=");
     *
     * @param start
     * @return
     */
    static String substring(String expr, String start) {
        return expr.substring(expr.indexOf(start) + start.length());
    }

    /**
     * Usage: String imidActual = UrlParser.substring(buyBox.getTitleUrl(), "-/", "?");
     *
     * @param start
     * @param end
     * @return
     */
    static String substring(String expr, String start, String end) {
        return expr.substring(expr.indexOf(start) + start.length(),
                              expr
                                  .indexOf(end));
    }

    /**
     * Returns the substring from last index of the separator.
     */
    static String getSubstringFromLastIndexOfSeparator(String string,
                                                       String separator) {
        return string.substring(string.lastIndexOf(separator) + separator.length())
                     .trim();
    }

    /**
     * Converts array of strings into a single string separating them by delimiter given.
     *
     * @param strings Array of strings/texts
     * @param delimiter Delimiter to be introduced between the strings/texts. Ex: ','
     * @return Instance of String
     */
    static String arrayToString(String[] strings, CharSequence delimiter) {
        StringBuffer temp = new StringBuffer();
        if (strings != null) {
            for (String s : strings) {
                temp.append(s + delimiter);
            }
            return temp.substring(0, (temp.length() - 1));
        } else {
            return null;
        }
    }
}
