package com.epam.text.reader;

import com.epam.text.exception.TextException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {

    public String readTextFromFile(String path) throws TextException {
        String text;
        try {
            text = Files.readString(Paths.get(path));
        } catch (IOException exception) {
            throw new TextException("Exception in read method");
        }
        return text;
    }
}
