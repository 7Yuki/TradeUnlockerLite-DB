package com.smile.settings;

public enum Items {
    ITEMS_TO_DROP("Cowhide", "Beef", "Egg", "Raw chicken"),
    BONES("Bones");

    private final String[] items;

    Items(String... items) {
        this.items = items;
    }

    public String[] getItems() {
        return items;
    }

}
