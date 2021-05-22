package com.epam.text.entity.impl;

import com.epam.text.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SymbolLeaf implements TextComponent {

    private final static Logger logger = LogManager.getLogger(SymbolLeaf.class);
    private char character;

    public SymbolLeaf(char character) {
        this.character = character;
    }
    @Override
    public void add(TextComponent textComponent) {
        logger.warn("Unsupported add operation in CharacterLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent textComponent) {
        logger.warn("Unsupported remove operation in CharacterLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getChild(int index) {
        logger.warn("Unsupported getChild operation in CharacterLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public CompositeType getType() {
        logger.warn("Unsupported getType operation in CharacterLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getChildList() {
        logger.warn("Unsupported getList operation in CharacterLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public int getChildListSize() {
        logger.warn("Unsupported getChildListSize operation in CharacterLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
