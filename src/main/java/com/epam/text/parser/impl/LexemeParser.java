package com.epam.text.parser.impl;

import com.epam.text.entity.impl.CompositeType;
import com.epam.text.entity.impl.TextComposite;
import com.epam.text.parser.AbstractTextParser;
import com.epam.text.parser.TextParserHelper;

public class LexemeParser extends AbstractTextParser {

    @Override
    public TextComposite parse(String data) {
        String[] lexemeList = TextParserHelper.getLexemes(data);
        TextComposite lexemeTextComposite = new TextComposite(CompositeType.LEXEME);
        for(String lexeme : lexemeList) {
            TextComposite nextComposite = nextParser.parse(lexeme);
            lexemeTextComposite.add(nextComposite);
        }
        return lexemeTextComposite;
    }
}
