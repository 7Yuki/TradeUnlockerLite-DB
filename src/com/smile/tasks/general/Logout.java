package com.smile.tasks.general;

import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.script.ScriptManager;
import org.dreambot.api.script.TaskNode;

public class Logout extends TaskNode {
    @Override
    public boolean accept() {
        return Skills.getRealLevel(Skill.ATTACK) >= 45 && Skills.getRealLevel(Skill.STRENGTH) >= 45 && Skills.getRealLevel(Skill.DEFENCE) >= 45;
    }

    @Override
    public int execute() {

        Tabs.logout();
        ScriptManager.getScriptManager().stop();
        return 800;
    }
}
