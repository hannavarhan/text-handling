package com.epam.text.parser.impl;

import com.epam.text.entity.Component;
import com.epam.text.entity.impl.CharacterLeaf;
import com.epam.text.entity.impl.Composite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.parser.ChainParser;
import com.epam.text.parser.TextParser;

import java.util.List;

public class CharacterParser implements ChainParser {

    private ChainParser nextParser;

    public CharacterParser(ChainParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Composite parse(String data) {
        List<Character> characterList = TextParser.parseCharacters(data);
        Composite characterComposite = new Composite(CompositeType.WORD);
        for (Character character : characterList) {
            Component component = new CharacterLeaf(character);
            characterComposite.add(component);
        }
        return characterComposite;
    }
}
