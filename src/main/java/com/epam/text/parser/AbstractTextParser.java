package com.epam.text.parser;

import com.epam.text.entity.impl.TextComposite;

public abstract class AbstractTextParser {

    protected AbstractTextParser nextParser = DefaultTextParser.getParser();

    public void setNextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract TextComposite parse(String data);

    private static class DefaultTextParser extends AbstractTextParser {

        private static DefaultTextParser defaultTextParser = new DefaultTextParser();

        public static AbstractTextParser getParser() {
            return defaultTextParser;
        }

        @Override
        public TextComposite parse(String data) {
            return null; //????????
        }
    }
}
