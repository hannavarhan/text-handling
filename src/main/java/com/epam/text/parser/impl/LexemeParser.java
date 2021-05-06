package com.epam.text.parser.impl;

import com.epam.text.entity.impl.TextComposite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.ChainParser;
import com.epam.text.parser.TextHelper;

import java.util.List;

public class LexemeParser implements ChainParser {

    private ChainParser nextParser;

    public LexemeParser(ChainParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public TextComposite parse(String data) {
        List<String> lexemeList = TextHelper.getLexemes(data);
        TextComposite lexemeTextComposite = new TextComposite(CompositeType.LEXEME);
        for (String lexeme : lexemeList) {
            TextComposite nextTextComposite = nextParser.parse(lexeme);
            lexemeTextComposite.add(nextTextComposite);
        }
        return lexemeTextComposite;
    }
}
