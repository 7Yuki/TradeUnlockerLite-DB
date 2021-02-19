package com.smile.settings;

public enum NPCTask {
    NONE("None"),
    CHICKEN("Chicken"),
    COW("Cow");

    private String name;

    NPCTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
