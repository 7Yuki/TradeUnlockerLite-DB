package com.smile.util.mouse;

import org.dreambot.api.input.Mouse;
import org.dreambot.api.wrappers.interactive.interact.Interactable;

public class MouseEvent {
    public boolean hover(Interactable entity) {
        return Mouse.getPosition() == entity.getClickablePoint() || Mouse.move(entity.getClickablePoint());
    }
}
