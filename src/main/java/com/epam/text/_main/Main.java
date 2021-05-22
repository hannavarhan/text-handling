package com.epam.text._main;

import com.epam.text.entity.impl.TextComposite;
import com.epam.text.exception.CompositeException;
import com.epam.text.parser.impl.*;
import com.epam.text.service.TextService;
import com.epam.text.service.impl.TextServiceImpl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, CompositeException {
        ClassLoader loader = Main.class.getClassLoader();
        URL resource = loader.getResource("file/test1.txt");
        String filepath = new File(resource.getFile()).getAbsolutePath();
        ArrayList<String> dataList = Files.lines(Paths.get(filepath))
                .collect(Collectors.toCollection(ArrayList::new));
        StringBuilder data = new StringBuilder();
        for (String line : dataList) {
            data.append(line);
        }

        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();
        LexemeParser lexemeParser = new LexemeParser();
        WordParser wordParser = new WordParser();
        CharacterParser characterParser = new CharacterParser();
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);
        wordParser.setNextParser(characterParser);
        TextComposite composite = paragraphParser.parse(data.toString());
        System.out.println(composite);
        System.out.println();
        TextService service = new TextServiceImpl();
        System.out.println(service.findLongWordSentences(composite));
        System.out.println(service.paragraphSort(composite));

    }
}
