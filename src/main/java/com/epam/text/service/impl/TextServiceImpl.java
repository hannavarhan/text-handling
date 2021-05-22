package com.epam.text.service.impl;

import com.epam.text.entity.TextComponent;
import com.epam.text.entity.impl.CompositeType;
import com.epam.text.entity.impl.TextComposite;
import com.epam.text.exception.CompositeException;
import com.epam.text.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {

    private final static Logger logger = LogManager.getLogger(TextServiceImpl.class);

    @Override
    public String paragraphSort(TextComposite textComposite) throws CompositeException {
        if (textComposite == null) {
            logger.error("Exception in findLongWordSentences because composite is null");
            throw new CompositeException("Exception in findLongWordSentences");
        } else if (textComposite.getType() != CompositeType.PARAGRAPH) {
            logger.error("Exception in findLongWordSentences: required CompositeType.PARAGRAPH, but found {}",
                    textComposite.getType());
            throw new CompositeException("Exception in findLongWordSentences");
        }
        List<TextComponent> list = textComposite.getChildList().stream()
                .sorted(new TextComposite.SentenceAmountComparator())
                .collect(Collectors.toList());
        String result = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
        return result;

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
        int maxWordLength = 0;
        List<Integer> numbers = new ArrayList<>();
        List<TextComponent> paragraphComponentList = textComposite.getChildList();
        for (int i = 0; i < paragraphComponentList.size(); i++) {
            List<TextComponent> sentenceComponentList = paragraphComponentList.get(i).getChildList();
            for (int j = 0; j < sentenceComponentList.size(); ++j) {
                TextComponent sentence = sentenceComponentList.get(j);
                List<TextComponent> lexemeComponentList = sentence.getChildList();
                boolean alreadyContains = false;
                for (TextComponent lexemeComponent : lexemeComponentList) {
                    TextComponent wordComponent = lexemeComponent.getChild(0);
                    int wordLength = wordComponent.toString().length();
                    if (wordLength > maxWordLength) {
                        maxWordLength = wordLength;
                        numbers = new ArrayList<>();
                        numbers.add(i);
                        numbers.add(j);
                        alreadyContains = true;
                    } else if (wordLength == maxWordLength) {
                        if (!alreadyContains) {
                            numbers.add(i);
                            numbers.add(j);
                        }
                    }
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            result.add(textComposite.getChild(numbers.get(i)).getChild(numbers.get(++i)).toString());
        }
        return result;
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
