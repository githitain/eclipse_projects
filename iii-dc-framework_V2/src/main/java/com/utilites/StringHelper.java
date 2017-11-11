package com.utilites;

import org.apache.commons.lang3.StringUtils;

import com.exceptions.TestException;

import java.util.ArrayList;
import java.util.List;

public final class StringHelper extends StringUtils 
{

    public static String normalizeSpaces(String initialString) {
        if (initialString == null) {
            return "";
        }

        String normalizedString = initialString.trim();
        while (normalizedString.contains("  ")) {
            normalizedString = normalizedString
                    .replace(Character.toString((char)160), " ")
                    .replace("  ", " ");
        }

        return normalizedString.trim();
    }

    public static String removeNewLineCharacters(String initialString) {
        return initialString.replace("\n", "").replace("\r", "");
    }

    /**
     * Convert string into word list
     * @param text
     * @return
     */
    public static List<String> convertToWordsList(String text) {
        List<String> wordsList = new ArrayList<>();
        String[] words = text.replaceAll("[,.]", "").split(" ");
        for (int i = 0; i < words.length; i++) {
            wordsList.add(words[i]);
        }
        return wordsList;
    }

    public static boolean isTextIncludeWords(String text, String words){
        return isTextIncludeWords(text,words,true);
    }

    /**
     * Convert string parameter words into words list and check that text contains all words. Verifying could be
     * with case ignoring(ignoreCase true, in this case words and text translate to lower case) or without it(ignoreCase false).
     * @param text
     * @param words
     * @param ignoreCase
     * @return true if text contains all words, false if it's not.
     */
    public static boolean isTextIncludeWords(String text, String words, boolean ignoreCase){
        if (ignoreCase){
            text = text.toLowerCase();
            words = words.toLowerCase();
        }
        List<String> wordsList = convertToWordsList(words);

        for (String word: wordsList){
            if (!text.contains(word)){
                return false;
            }
        }
        return true;
    }

    public static Integer convertToInt(String value) {
        if (!isIntNumber(value)) {
            throw new TestException(String.format("'%s' is not integer number", value));
        }
        return Integer.parseInt(value);
    }

    public static boolean isIntNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isCurrencyFormat(String value) {
        if (!(value.startsWith("$") && value.contains(".")))
            return false;
        String[] dollarParts;
        String currency = value.substring(1);
        String[] parts = currency.split("\\.");
        String dollarPart = parts[0];
        String decimalPart = parts[1];

        if ((parts.length > 2) || dollarPart.length() > 10 || decimalPart.length() != 2 || !isIntNumber(decimalPart)) {
            return false;
        }

        if (dollarPart.length() > 3) {
            dollarParts = dollarPart.split(",");
            if (dollarParts.length < 2) return false;
            for (int i = 0; i < dollarParts.length; i++) {
                String number = dollarParts[i];
                int length = number.length();

                if (i == 0) {
                    if (!isIntNumber(number) || !(length > 0 && length <= 3)) return false;
                } else {
                    if (length != 3 || !isIntNumber(number)) return false;
                }
            }
        } else {
            if (!isIntNumber(dollarPart)) return false;
        }
        return true;
    }

    public static String getEmailWithSuffix(String email) {
        String[] parts = email.split("@");
        return parts[0] + TestRunSuffix.getCurrentTestSuffix() + "@" + parts[1];
    }

}

