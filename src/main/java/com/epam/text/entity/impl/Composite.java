package com.epam.text.entity.impl;

import com.epam.text.entity.Component;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Composite implements Component {

    private ArrayList<Component> components = new ArrayList<>();
    private CompositeType compositeType;
    private final static Logger logger = LogManager.getLogger(Composite.class);

    public Composite(CompositeType compositeType) {
        this.compositeType = compositeType;
    }

    @Override
    public List<Component> getList() {
        logger.info("Composite -> get list");
        return components;
    }

    @Override
    public void add(Component component) {
        logger.info("Composite -> adding child");
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        logger.info("Composite -> deleting child");
        components.remove(component);
    }

    @Override
    public Component getChild(int index) {
        logger.info("Composite -> getting child");
        return components.get(index);
    }

    @Override
    public CompositeType getType() {
        logger.info("Composite -> getting type: {}", compositeType);
        return compositeType;

    }

    @Override
    public String toString() { //fix
        return "Composite{" +
                "components=" + components +
                ", compositeType=" + compositeType +
                '}';
    }
}
