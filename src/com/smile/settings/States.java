package com.smile.settings;

public enum States {
    NOTHING("Nothing"),
    ATTACKING("Attacking"),
    WALKING("Walking");

    private String state;
    States(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
