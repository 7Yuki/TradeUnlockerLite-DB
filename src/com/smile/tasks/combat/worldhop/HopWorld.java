package com.smile.tasks.combat.worldhop;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.world.World;
import org.dreambot.api.methods.world.Worlds;
import org.dreambot.api.methods.worldhopper.WorldHopper;
import org.dreambot.api.script.TaskNode;
import java.util.Objects;

public class HopWorld extends TaskNode {
    @Override
    public boolean accept() {
        return Players.all(Objects::nonNull).toArray().length > 4 && !Players.localPlayer().isInCombat();
    }

    @Override
    public int priority() {
        return 4;
    }

    @Override
    public int execute() {
        World randomFreeWorld = Worlds.getRandomWorld(w -> w != null && w.isF2P() && w.isNormal());
        if (WorldHopper.isWorldHopperOpen()) {
            WorldHopper.hopWorld(randomFreeWorld);
            if (Worlds.getCurrentWorld() == randomFreeWorld.getWorld()) {
                if (!Tabs.isOpen(Tab.INVENTORY)) {
                    Tabs.openWithFKey(Tab.INVENTORY);
                } else {
                    sleep(650,750);
                }
            }
        } else {
            WorldHopper.openWorldHopper();
            sleep(300,700);
        }
        return Calculations.random(1000,1500);
    }
}
