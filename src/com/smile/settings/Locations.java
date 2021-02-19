package com.smile.settings;

import org.dreambot.api.methods.map.Area;

public enum Locations {
    NONE("None", null),
    CHICKEN_COOP("Chicken Coop", new Area(3225, 3300, 3235, 3295)),
    COW_PEN("Cow Pen", new Area(3194, 3300, 3210, 3285));

    private String name;
    private Area area;
    Locations(String name, Area area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public Area getArea() {
        return area;
    }
}
