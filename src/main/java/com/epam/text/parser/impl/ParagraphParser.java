package com.epam.text.parser.impl;

import com.epam.text.entity.impl.TextComposite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.ChainParser;
import com.epam.text.parser.TextHelper;

import java.util.List;

public class ParagraphParser implements ChainParser {

    private ChainParser nextParser;

    public ParagraphParser(ChainParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public TextComposite parse(String data) {
        List<String> paragraphList = TextHelper.getParagraphs(data);
        TextComposite paragraphTextComposite = new TextComposite(CompositeType.PARAGRAPH);
        for (String paragraph : paragraphList) {
            TextComposite nextTextComposite = nextParser.parse(paragraph);
            paragraphTextComposite.add(nextTextComposite);
        }
        return paragraphTextComposite;

    }
}
