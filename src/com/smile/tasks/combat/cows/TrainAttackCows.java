package com.smile.tasks.combat.cows;

import com.smile.methods.combat.CombatStyle;
import com.smile.settings.Locations;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.script.TaskNode;

public class TrainAttackCows extends TaskNode {
    @Override
    public boolean accept() {
        return Skills.getRealLevel(Skill.ATTACK) <= 45 && Skills.getRealLevel(Skill.DEFENCE) >= 45 && Skills.getRealLevel(Skill.STRENGTH) >= 45 && Locations.COW_PEN.getArea().contains(Players.localPlayer()) && PlayerSettings.getConfig(43) != 0;
    }
    @Override
    public int priority() {
        return 4;
    }
    @Override
    public int execute() {
        CombatStyle.changeCombatStlye(0,4,"Attack");
        return Calculations.random(1000,1200);
    }
}
