package com.epam.text.service;

import com.epam.text.entity.impl.Composite;
import com.epam.text.exception.CompositeException;

import java.util.List;
import java.util.Map;

public interface TextService {

    String paragraphSort(Composite composite);

    List<String> findLongWordSentences(Composite composite) throws CompositeException;

    List<String> removeSentences(Composite composite, int wordAmount);

    Map<String, Integer> countSameWords(Composite composite);

    int countVowel(Composite composite);

    int countConsonant(Composite composite);
}
