package com.epam.text.entity;

import com.epam.text.entity.impl.CompositeType;

import java.util.List;

public interface Component {
    void add(Component component);

    void remove(Component component);

    Component getChild(int index);

    CompositeType getType();

    List<Component> getList();
}
