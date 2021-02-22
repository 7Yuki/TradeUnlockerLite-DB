package com.smile.tasks.combat.chickens;

import com.smile.methods.combat.CombatStyle;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.script.TaskNode;

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
        CombatStyle.changeCombatStlye(3,16,"Defence");
        return Calculations.random(1000,1200);
    }
}
