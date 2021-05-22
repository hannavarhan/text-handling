package com.epam.text.parser.impl;

import com.epam.text.entity.impl.CompositeType;
import com.epam.text.entity.impl.TextComposite;
import com.epam.text.parser.AbstractTextParser;
import com.epam.text.parser.TextParserHelper;

import java.util.List;

public class SentenceParser extends AbstractTextParser {

    @Override
    public TextComposite parse(String data) {
        List<String> sentenceList = TextParserHelper.getSentences(data);
        TextComposite sentenceTextComposite = new TextComposite(CompositeType.SENTENCE);
        for (String sentence : sentenceList) {
            TextComposite nextTextComposite = nextParser.parse(sentence);
            sentenceTextComposite.add(nextTextComposite);
        }
        return sentenceTextComposite;
    }
}
