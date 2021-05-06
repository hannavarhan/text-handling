package com.epam.text.parser.impl;

import com.epam.text.entity.impl.TextComposite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.ChainParser;
import com.epam.text.parser.TextHelper;

import java.util.List;

public class WordParser implements ChainParser {

    private ChainParser nextParser;

    public WordParser(ChainParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public TextComposite parse(String data) {
        List<String> wordList = TextHelper.getWords(data);
        TextComposite wordTextComposite = new TextComposite(CompositeType.WORD);
        for (String word : wordList) {
            TextComposite nextTextComposite = nextParser.parse(word);
            wordTextComposite.add(nextTextComposite);
        }
        return wordTextComposite;
    }
}
