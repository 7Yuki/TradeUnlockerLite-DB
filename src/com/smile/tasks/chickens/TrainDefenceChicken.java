package com.smile.tasks.chickens;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.utilities.StatusBar;
import org.dreambot.api.wrappers.widgets.WidgetChild;

public class TrainDefenceChicken extends TaskNode {
    @Override
    public boolean accept() {
        return !(Skills.getRealLevel(Skill.DEFENCE) >= 19) && Skills.getRealLevel(Skill.ATTACK) >= 19 && Skills.getRealLevel(Skill.STRENGTH) >= 19 && PlayerSettings.getConfig(43) != 3;
    }

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public int execute() {
        WidgetChild accurateWidget = Widgets.getWidget(593).getChild(16);
        if (PlayerSettings.getConfig(43) != 3) {
            StatusBar.info("Switching to Defence until level 19", false);
            log("Switching to Defence until level 19");
            if (Tabs.isOpen(Tab.COMBAT)) {
                if(accurateWidget.interact() && PlayerSettings.getConfig(43) == 3) {
                    StatusBar.info("Now gaining Defence XP", false);
                    Tabs.openWithFKey(Tab.INVENTORY);
                }
            } else {
                Tabs.openWithFKey(Tab.COMBAT);
            }
        }
        return Calculations.random(1000,1200);
    }
}
