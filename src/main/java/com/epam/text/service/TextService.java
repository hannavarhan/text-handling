package com.epam.text.service;

import com.epam.text.entity.impl.TextComposite;
import com.epam.text.exception.CompositeException;

import java.util.List;
import java.util.Map;

public interface TextService {

    String paragraphSort(TextComposite textComposite);

    List<String> findLongWordSentences(TextComposite textComposite) throws CompositeException;

    List<String> removeSentences(TextComposite textComposite, int wordAmount);

    Map<String, Integer> countSameWords(TextComposite textComposite);

    int countVowel(TextComposite textComposite);

    int countConsonant(TextComposite textComposite);
}
