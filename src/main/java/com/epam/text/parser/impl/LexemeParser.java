package com.epam.text.parser.impl;

import com.epam.text.entity.impl.Composite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.ChainParser;
import com.epam.text.parser.TextParser;

import java.util.List;

public class LexemeParser implements ChainParser {

    private ChainParser nextParser;

    public LexemeParser(ChainParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Composite parse(String data) {
        List<String> lexemeList = TextParser.parseLexemes(data);
        Composite lexemeComposite = new Composite(CompositeType.LEXEME);
        for (String lexeme : lexemeList) {
            Composite nextComposite = nextParser.parse(lexeme);
            lexemeComposite.add(nextComposite);
        }
        return lexemeComposite;
    }
}
