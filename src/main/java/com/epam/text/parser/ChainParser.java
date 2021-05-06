package com.epam.text.parser;

import com.epam.text.entity.impl.TextComposite;

public interface ChainParser {
    TextComposite parse(String data);
}
