package com.smile.tasks.cows;

import com.smile.main;
import com.smile.settings.Locations;
import com.smile.settings.NPCTask;
import com.smile.settings.States;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.wrappers.interactive.NPC;

public class AttackCows extends TaskNode {
    @Override
    public boolean accept() {
        return (Skills.getRealLevel(Skill.ATTACK) <= 45)
                && (Skills.getRealLevel(Skill.STRENGTH) <= 45)
                && (Skills.getRealLevel(Skill.DEFENCE) <= 45);
    }

    @Override
    public int execute() {
        NPC cow = NPCs.closest(c -> c != null && c.getName().equals("Cow") && !c.isInCombat() && c.hasAction("Attack") && c.canAttack());
        if (Locations.COW_PEN.getArea().contains(Players.localPlayer())) {
            if (cow != null) {
                main.npc = NPCTask.COW;
                main.location = Locations.COW_PEN;
                if (!Players.localPlayer().isInCombat()) {
                    if(cow.interact("Attack")) {
                        main.state = States.ATTACKING;
                    }
                } else {
                    Mouse.moveMouseOutsideScreen();
                    sleepWhile(() -> Players.localPlayer().isAnimating(), cow::exists,5000,5);
                    main.state = States.ATTACKING;

                }
            }
        } else {
            Walking.walk(Locations.COW_PEN.getArea().getRandomTile());
        }


        return Calculations.random(1000,1200);
    }
}
