package com.smile.tasks.combat.chickens;

import com.smile.methods.combat.CombatStyle;
import com.smile.settings.Locations;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.script.TaskNode;

public class TrainStrengthChicken extends TaskNode {
    @Override
    public boolean accept() {
        return !(Skills.getRealLevel(Skill.STRENGTH) >= 19) && Locations.CHICKEN_COOP.getArea().contains(Players.localPlayer()) && PlayerSettings.getConfig(43) != 1;
    }
    @Override
    public int priority() {
        return 2;
    }



    @Override
    public int execute() {
        CombatStyle.changeCombatStlye(1,8,"Strength");
        return Calculations.random(1000,1200);
    }
}
