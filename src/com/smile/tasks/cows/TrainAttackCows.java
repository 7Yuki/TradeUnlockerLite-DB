package com.smile.tasks.cows;

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
import org.dreambot.api.utilities.StatusBar;
import org.dreambot.api.wrappers.widgets.WidgetChild;

public class TrainAttackCows extends TaskNode {
    @Override
    public boolean accept() {
        return Skills.getRealLevel(Skill.ATTACK) <= 45 && Skills.getRealLevel(Skill.DEFENCE) >= 45 && Skills.getRealLevel(Skill.STRENGTH) >= 45 && Locations.COW_PEN.getArea().contains(Players.localPlayer()) && PlayerSettings.getConfig(43) != 0;
    }
    @Override
    public int priority() {
        return 2;
    }
    @Override
    public int execute() {
        WidgetChild accurateWidget = Widgets.getWidget(593).getChild(4);
        if (PlayerSettings.getConfig(43) != 0) {
            StatusBar.info("Switching to Attack until level 45", false);
            log("Switching to Attack until level 45");
            if (Tabs.isOpen(Tab.COMBAT)) {
                if(accurateWidget.interact() && PlayerSettings.getConfig(43) == 0) {
                    StatusBar.info("Now gaining Strength XP", false);
                    Tabs.openWithFKey(Tab.INVENTORY);
                }
            } else {
                Tabs.openWithFKey(Tab.COMBAT);
            }
        }
        return Calculations.random(1000,1200);
    }
}
