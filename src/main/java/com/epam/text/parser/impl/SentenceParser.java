package com.epam.text.parser.impl;

import com.epam.text.entity.impl.Composite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.ChainParser;
import com.epam.text.parser.TextParser;

import java.util.List;

public class SentenceParser implements ChainParser {

    private ChainParser nextParser;

    public SentenceParser(ChainParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Composite parse(String data) {
        List<String> sentenceList = TextParser.parseSentences(data);
        Composite sentenceComposite = new Composite(CompositeType.SENTENCE);
        for (String sentence : sentenceList) {
            Composite nextComposite = nextParser.parse(sentence);
            sentenceComposite.add(nextComposite);
        }
        return sentenceComposite;
    }
}
