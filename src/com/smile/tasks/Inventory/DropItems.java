package com.smile.tasks.Inventory;

import com.smile.settings.Items;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.script.TaskNode;

public class DropItems extends TaskNode {
    @Override
    public boolean accept() {
        return Inventory.contains(Items.ITEMS_TO_DROP.getItems()) && !Players.localPlayer().isInCombat();
    }

    @Override
    public int priority() {
        return 5;
    }

    @Override
    public int execute() {
        Inventory.dropAll(Items.ITEMS_TO_DROP.getItems());
        return Calculations.random(1000,1500);
    }
}
