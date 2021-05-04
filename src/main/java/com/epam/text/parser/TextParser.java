package com.epam.text.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private static final String PARAGRAPH_REGEX = "[^\\n\\t]+";
    private static final String SENTENCE_REGEX = "/([А-ЯA-Z]((!=|ob.)|[^?!.(]|\\([^)]*\\))*[.?!]{1,3})/gm";
    private static final String LEXEME_REGEX = "\\S+";
    private static final String WORD_REGEX = "[\\\"\\wА-я']+(-[\\\"\\wА-я']+)*";
    private static final String CHARACTER_REGEX = "\\S";

    public static List<String> parseParagraphs(String data) {
        return parse(data, PARAGRAPH_REGEX);
    }

    public static List<String> parseSentences(String data) {
        return parse(data, SENTENCE_REGEX);
    }

    public static List<String> parseLexemes(String data) {
        return parse(data, LEXEME_REGEX);
    }

    public static List<String> parseWords(String data) {
        return parse(data, WORD_REGEX);
    }

    public static List<Character> parseCharacters(String data) {
        Pattern pattern = Pattern.compile(CHARACTER_REGEX);
        Matcher matcher = pattern.matcher(data);
        List<Character> result = new ArrayList<>();
        while (matcher.find()) {
            char element = matcher.group().charAt(0);
            result.add(element);
        }
        return result;
    }

    private static List<String> parse(String data, final String regex) {
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
