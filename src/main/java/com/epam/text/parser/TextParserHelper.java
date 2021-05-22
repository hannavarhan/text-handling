package com.epam.text.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParserHelper {

    private static final String PARAGRAPH_REGEX = "[^\\n\\t]+";
    private static final String SENTENCE_REGEX = "([А-ЯA-Z]((!=|.toString)|[^?!.(]|\\([^)]*\\))*[.?!]{1,3})";
    private static final String LEXEME_REGEX = "[\\s]+";
    private static final String CHARACTER_REGEX = "\\S";
    private static final String CHARACTER_REGEX2 = "[.=,!?:;)(\\t\\n]|\\S";

    public static List<String> getParagraphs(String data) {
        return getTextByMatch(data, PARAGRAPH_REGEX);
    }

    public static List<String> getSentences(String data) {
        return getTextByMatch(data, SENTENCE_REGEX);
    }

    public static String[] getLexemes(String data) {
        return getTextBySplit(data, LEXEME_REGEX);
    }

    public static List<Character> getCharacters(String data) {
        Pattern pattern = Pattern.compile(CHARACTER_REGEX);
        Matcher matcher = pattern.matcher(data);
        List<Character> result = new ArrayList<>();
        while (matcher.find()) {
            char element = matcher.group().charAt(0);
            result.add(element);
        }
        return result;
    }

    private static String[] getTextBySplit(String data, final String regex) {
        String[] result = data.split(regex);
        return result;
    }

    private static List<String> getTextByMatch(String data, final String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
            System.out.println(matcher.group());
            System.out.println();
        }
        return result;
    }
}
