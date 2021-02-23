package com.smile.tasks.combat.chickens;


import com.smile.util.events.widgets.WidgetEvent;
import com.smile.settings.Locations;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.script.TaskNode;

public class TrainAttackChicken extends TaskNode {
    @Override
    public boolean accept() {
        return !(Skills.getRealLevel(Skill.ATTACK) >= 19) && Skills.getRealLevel(Skill.STRENGTH) >= 19 && Locations.CHICKEN_COOP.getArea().contains(Players.localPlayer()) && PlayerSettings.getConfig(43) != 0;
    }
    @Override
    public int priority() {
        return 2;
    }

    @Override
    public int execute() {
        new WidgetEvent().changeCombatStlye(0,4,"Attack");
        return Calculations.random(1000,1200);
    }
}
