package com.smile.tasks;

import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.script.ScriptManager;
import org.dreambot.api.script.TaskNode;

public class StopScript extends TaskNode {
    @Override
    public boolean accept() {
        return Skills.getRealLevel(Skill.ATTACK) >= 45 && Skills.getRealLevel(Skill.STRENGTH) >= 45 && Skills.getRealLevel(Skill.DEFENCE) >= 45;
    }

    @Override
    public int execute() {
        ScriptManager.getScriptManager().stop();
        return 800;
    }
}
