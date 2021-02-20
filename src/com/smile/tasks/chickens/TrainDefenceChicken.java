package com.smile.tasks.chickens;

import com.smile.settings.Locations;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.wrappers.widgets.WidgetChild;

public class TrainDefenceChicken extends TaskNode {
    @Override
    public boolean accept() {
        return Skills.getRealLevel(Skill.DEFENCE) <= 19 && Skills.getRealLevel(Skill.ATTACK) >= 19 && Skills.getRealLevel(Skill.STRENGTH) >= 19 && Locations.CHICKEN_COOP.getArea().contains(Players.localPlayer());
    }

    @Override
    public int execute() {
        WidgetChild accurateWidget = Widgets.getWidget(593).getChild(16);
        if (PlayerSettings.getConfig(43) != 3) {
            if (Tabs.isOpen(Tab.COMBAT)) {
                if(accurateWidget.interact()) {
                    Tabs.openWithFKey(Tab.INVENTORY);
                }
            } else {
                Tabs.openWithFKey(Tab.COMBAT);
            }
        }
        return Calculations.random(1000,1200);
    }
}