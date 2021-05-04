package com.epam.text.parser.impl;

import com.epam.text.entity.impl.Composite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.ChainParser;
import com.epam.text.parser.TextParser;

import java.util.List;

public class ParagraphParser implements ChainParser {

    private ChainParser nextParser;

    public ParagraphParser(ChainParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Composite parse(String data) {
        List<String> paragraphList = TextParser.parseParagraphs(data);
        Composite paragraphComposite = new Composite(CompositeType.PARAGRAPH);
        for (String paragraph : paragraphList) {
            Composite nextComposite = nextParser.parse(paragraph);
            paragraphComposite.add(nextComposite);
        }
        return paragraphComposite;

    }
}
