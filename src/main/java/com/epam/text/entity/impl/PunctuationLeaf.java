package com.epam.text.entity.impl;

import com.epam.text.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PunctuationLeaf implements TextComponent {

    private final static Logger logger = LogManager.getLogger(PunctuationLeaf.class);
    private char punctuation;

    public PunctuationLeaf(char punctuation) {
        this.punctuation = punctuation;
    }
    @Override
    public void add(TextComponent textComponent) {
        logger.warn("Unsupported add operation in PunctuationLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent textComponent) {
        logger.warn("Unsupported remove operation in PunctuationLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getChild(int index) {
        logger.warn("Unsupported getChild operation in PunctuationLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public CompositeType getType() {
        logger.warn("Unsupported getType operation in PunctuationLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getChildList() {
        logger.warn("Unsupported getList operation in PunctuationLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public int getChildListSize() {
        logger.warn("Unsupported getChildListSize operation in PunctuationLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(punctuation);
    }
}
