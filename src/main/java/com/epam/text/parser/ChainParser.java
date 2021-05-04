package com.epam.text.parser;

import com.epam.text.entity.impl.Composite;

public interface ChainParser {
    Composite parse(String data);
}
