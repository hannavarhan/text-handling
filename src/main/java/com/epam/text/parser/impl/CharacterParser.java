package com.epam.text.parser.impl;

import com.epam.text.entity.TextComponent;
import com.epam.text.entity.impl.SymbolLeaf;
import com.epam.text.entity.impl.TextComposite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.AbstractTextParser;
import com.epam.text.parser.TextParserHelper;

import java.util.List;

public class CharacterParser extends AbstractTextParser {

    @Override
    public TextComposite parse(String data) {
        List<Character> characterList = TextParserHelper.getCharacters(data);
        TextComposite characterTextComposite = new TextComposite(CompositeType.SYMBOL);
        for (Character character : characterList) {
            TextComponent textComponent = new SymbolLeaf(character);
            characterTextComposite.add(textComponent);
        }
        return characterTextComposite;
    }
}
