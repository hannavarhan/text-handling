package com.epam.text.parser.impl;

import com.epam.text.entity.impl.Composite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.ChainParser;
import com.epam.text.parser.TextParser;

import java.util.List;

public class WordParser implements ChainParser {

    private ChainParser nextParser;

    public WordParser(ChainParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Composite parse(String data) {
        List<String> wordList = TextParser.parseWords(data);
        Composite wordComposite = new Composite(CompositeType.WORD);
        for (String word : wordList) {
            Composite nextComposite = nextParser.parse(word);
            wordComposite.add(nextComposite);
        }
        return wordComposite;
    }
}
