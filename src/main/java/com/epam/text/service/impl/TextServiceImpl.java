package com.epam.text.service.impl;

import com.epam.text.entity.impl.TextComposite;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.exception.CompositeException;
import com.epam.text.parser.TextHelper;
import com.epam.text.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TextServiceImpl implements TextService {

    private final static Logger logger = LogManager.getLogger(TextServiceImpl.class);

    @Override
    public String paragraphSort(TextComposite textComposite) {
        return null;
    }

    @Override
    public List<String> findLongWordSentences(TextComposite textComposite) throws CompositeException { //to do
        if (textComposite == null) {
            logger.error("Exception in findLongWordSentences because composite is null");
            throw new CompositeException("Exception in findLongWordSentences");
        } else if (textComposite.getType() != CompositeType.PARAGRAPH) {
            logger.error("Exception in findLongWordSentences: required CompositeType.PARAGRAPH, but found {}",
                    textComposite.getType());
            throw new CompositeException("Exception in findLongWordSentences");
        }
        String text = textComposite.toString();
        List<String> words = TextHelper.getWords(text);
        words.sort(Comparator.comparing(String::length));
        return null;
    }

    @Override
    public List<String> removeSentences(TextComposite textComposite, int wordAmount) {
        return null;
    }

    @Override
    public Map<String, Integer> countSameWords(TextComposite textComposite) {
        return null;
    }

    @Override
    public int countVowel(TextComposite textComposite) {
        return 0;
    }

    @Override
    public int countConsonant(TextComposite textComposite) {
        return 0;
    }
}
