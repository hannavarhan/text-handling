package com.epam.text.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHelper {

    private static final String PARAGRAPH_REGEX = "[^\\n\\t]+";
    private static final String SENTENCE_REGEX = "/([А-ЯA-Z]((!=|ob.)|[^?!.(]|\\([^)]*\\))*[.?!]{1,3})/gm";
    private static final String LEXEME_REGEX = "\\S+";
    private static final String WORD_REGEX = "[\\\"\\wА-я']+(-[\\\"\\wА-я']+)*";
    private static final String CHARACTER_REGEX = "\\S";

    public static List<String> getParagraphs(String data) {
        return getText(data, PARAGRAPH_REGEX);
    }

    public static List<String> getSentences(String data) {
        return getText(data, SENTENCE_REGEX);
    }

    public static List<String> getLexemes(String data) {
        return getText(data, LEXEME_REGEX);
    }

    public static List<String> getWords(String data) {
        return getText(data, WORD_REGEX);
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

    private static List<String> getText(String data, final String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            String element = matcher.group();
            result.add(element);
        }
        return result;
    }
}
