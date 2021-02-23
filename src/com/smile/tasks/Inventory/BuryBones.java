package com.smile.tasks.Inventory;

import com.smile.settings.Items;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.TaskNode;

public class BuryBones extends TaskNode {
    @Override
    public boolean accept() {
        return Inventory.contains(Items.BONES.getItems()) && !Players.localPlayer().isInCombat();
    }

    @Override
    public int priority() {
        return 5;
    }

    @Override
    public int execute() {
        Inventory.interact(Items.BONES.getItems()[0], "Bury");
        return Calculations.random(1000,1200);
    }
}
