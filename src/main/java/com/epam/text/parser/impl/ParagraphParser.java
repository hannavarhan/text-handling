package com.epam.text.parser.impl;

import com.epam.text.entity.impl.CompositeType;
import com.epam.text.entity.impl.TextComposite;
import com.epam.text.parser.AbstractTextParser;
import com.epam.text.parser.TextParserHelper;

import java.util.List;

public class ParagraphParser extends AbstractTextParser {

    @Override
    public TextComposite parse(String data) {
        List<String> paragraphList = TextParserHelper.getParagraphs(data);
        TextComposite paragraphTextComposite = new TextComposite(CompositeType.PARAGRAPH);
        for (String paragraph : paragraphList) {
            TextComposite nextTextComposite = nextParser.parse(paragraph);
            paragraphTextComposite.add(nextTextComposite);
        }
        return paragraphTextComposite;

    }

}
