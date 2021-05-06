package com.epam.text.parser.impl;

import com.epam.text.entity.impl.TextComposite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.ChainParser;
import com.epam.text.parser.TextHelper;

import java.util.List;

public class SentenceParser implements ChainParser {

    private ChainParser nextParser;

    public SentenceParser(ChainParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public TextComposite parse(String data) {
        List<String> sentenceList = TextHelper.getSentences(data);
        TextComposite sentenceTextComposite = new TextComposite(CompositeType.SENTENCE);
        for (String sentence : sentenceList) {
            TextComposite nextTextComposite = nextParser.parse(sentence);
            sentenceTextComposite.add(nextTextComposite);
        }
        return sentenceTextComposite;
    }
}
