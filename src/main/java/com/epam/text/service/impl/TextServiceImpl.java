package com.epam.text.service.impl;

import com.epam.text.entity.Component;
import com.epam.text.entity.impl.Composite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.exception.CompositeException;
import com.epam.text.parser.TextParser;
import com.epam.text.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TextServiceImpl implements TextService {

    private final static Logger logger = LogManager.getLogger(TextServiceImpl.class);

    @Override
    public String paragraphSort(Composite composite) {
        return null;
    }

    @Override
    public List<String> findLongWordSentences(Composite composite) throws CompositeException { //to do
        if (composite == null) {
            logger.error("Exception in findLongWordSentences because composite is null");
            throw new CompositeException("Exception in findLongWordSentences");
        } else if (composite.getType() != CompositeType.PARAGRAPH) {
            logger.error("Exception in findLongWordSentences: required CompositeType.PARAGRAPH, but found {}",
                    composite.getType());
            throw new CompositeException("Exception in findLongWordSentences");
        }
        String text = composite.toString();
        List<String> words = TextParser.parseWords(text);
        words.sort(Comparator.comparing(String::length));
        return null;
    }

    @Override
    public List<String> removeSentences(Composite composite, int wordAmount) {
        return null;
    }

    @Override
    public Map<String, Integer> countSameWords(Composite composite) {
        return null;
    }

    @Override
    public int countVowel(Composite composite) {
        return 0;
    }

    @Override
    public int countConsonant(Composite composite) {
        return 0;
    }
}
