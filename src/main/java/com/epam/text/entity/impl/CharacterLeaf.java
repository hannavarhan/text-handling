package com.epam.text.entity.impl;

import com.epam.text.entity.Component;

import java.util.List;

public class CharacterLeaf implements Component {
    private char character;

    public CharacterLeaf(char character) {
        this.character = character;
    }
    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompositeType getType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
