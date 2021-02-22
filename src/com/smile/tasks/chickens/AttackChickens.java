package com.smile.tasks.chickens;

import com.smile.main;
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
import org.dreambot.api.utilities.StatusBar;
import org.dreambot.api.wrappers.interactive.NPC;

import static com.smile.settings.Locations.CHICKEN_COOP;

public class AttackChickens extends TaskNode {
    @Override
    public boolean accept() {
        return (Skills.getRealLevel(Skill.ATTACK) <= 19)
                || (Skills.getRealLevel(Skill.STRENGTH) <= 19)
                || (Skills.getRealLevel(Skill.DEFENCE) <= 19)
                && !Players.localPlayer().isInCombat();
    }
    @Override
    public int priority() {
        return 1;
    }
    @Override
    public int execute() {
        NPC chickens = NPCs.closest(q -> q != null && q.getName().equals("Chicken") && !q.isInCombat() && q.hasAction("Attack") && q.canAttack());
        if (CHICKEN_COOP.getArea().contains(Players.localPlayer())) {
            if (chickens != null) {
                main.npc = NPCTask.CHICKEN;
                main.location = CHICKEN_COOP;
                if (!Players.localPlayer().isInteractedWith() && !Players.localPlayer().isAnimating()) {
                    if (chickens.interact("Attack")) {
                        main.state = States.ATTACKING;
                        Mouse.moveMouseOutsideScreen();
                        StatusBar.info("Attacking chicken", false);
                    }
                } else {
                        sleepWhile(() -> Players.localPlayer().isAnimating(), chickens::exists,5000,5);
                    }
                }
        } else {
            if (!CHICKEN_COOP.getArea().contains(Players.localPlayer())) {
                StatusBar.info("Walking to Chicken coop", false);
                Walking.walk(CHICKEN_COOP.getArea().getRandomTile());
            }
        }
        return Calculations.random(1000,1200);
    }
}
