package com.epam.text.parser.impl;

import com.epam.text.entity.TextComponent;
import com.epam.text.entity.impl.SymbolLeaf;
import com.epam.text.entity.impl.TextComposite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.ChainParser;
import com.epam.text.parser.TextHelper;

import java.util.List;

public class CharacterParser implements ChainParser {

    private ChainParser nextParser;

    public CharacterParser(ChainParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public TextComposite parse(String data) {
        List<Character> characterList = TextHelper.getCharacters(data);
        TextComposite characterTextComposite = new TextComposite(CompositeType.WORD);
        for (Character character : characterList) {
            TextComponent textComponent = new SymbolLeaf(character);
            characterTextComposite.add(textComponent);
        }
        return characterTextComposite;
    }
}
