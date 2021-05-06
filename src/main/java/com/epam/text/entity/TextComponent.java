package com.epam.text.entity;

import com.epam.text.entity.impl.CompositeType;

import java.util.List;

public interface TextComponent {
    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    TextComponent getChild(int index);

    CompositeType getType();

    List<TextComponent> getChildList();
}
