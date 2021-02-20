package com.smile;

import com.smile.mouse.EaseMouse;
import com.smile.settings.Locations;
import com.smile.settings.NPCTask;
import com.smile.settings.States;
import com.smile.tasks.chickens.AttackChickens;
import com.smile.tasks.chickens.TrainAttackChicken;
import com.smile.tasks.chickens.TrainDefenceChicken;
import com.smile.tasks.chickens.TrainStrengthChicken;
import com.smile.tasks.cows.AttackCows;
import com.smile.tasks.cows.TrainAttackCows;
import com.smile.tasks.cows.TrainDefenceCows;
import com.smile.tasks.cows.TrainStrengthCows;
import org.dreambot.api.Client;
import org.dreambot.api.data.GameState;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.impl.TaskScript;

import java.awt.*;
import java.util.concurrent.TimeUnit;

@ScriptManifest(category = Category.COMBAT, name = "Trade Restrictions Lite", author = "smile", version = 0.3)
public class main extends TaskScript {
    public static Locations location = Locations.NONE;
    public static NPCTask npc = NPCTask.NONE;
    public static States state = States.NOTHING;
    private long timeStart, timeRan;

    @Override
    public void onStart() {
        super.onStart();
        Client.getInstance().setMouseMovementAlgorithm(new EaseMouse());
        SkillTracker.start();
        timeStart = System.currentTimeMillis();
        addNodes(
                new AttackChickens(),
                new AttackCows(),

                new TrainAttackCows(),
                new TrainDefenceCows(),
                new TrainStrengthCows(),

                new TrainAttackChicken(),
                new TrainStrengthChicken(),
                new TrainDefenceChicken()
        );
    }
    private String ft(long duration) {
        String res;
        long days = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration)
                - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                .toHours(duration));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                .toMinutes(duration));
        if (days == 0) {
            res = (hours + ":" + minutes + ":" + seconds);
        } else {
            res = (days + ":" + hours + ":" + minutes + ":" + seconds);
        }
        return res;
    }

    @Override
    public void onPaint(Graphics2D g) {
        timeRan = System.currentTimeMillis() - timeStart;
        super.onPaint(g);

        g.setColor(new Color(80,255,140,255));
        g.drawRect(8,17,165,125);
        g.setColor(new Color(0,0,0,175));
        g.fillRect(10,19,163,123);

        g.setColor(Color.WHITE);
        g.drawString("sTradeRestriction Lite v" + getVersion(),12,35);
        g.drawString("Runtime: " + ft(timeRan),12,50);
        if(Client.getGameState() == GameState.LOGGED_IN) {
            g.drawString("Location: " + location.getName(), 12,65);
            g.drawString("State: " + state.getState() + " - " + npc.getName() ,12,77);
            g.drawString("HP: " + Skills.getRealLevel(Skill.HITPOINTS) + " (+" + SkillTracker.getGainedLevels(Skill.HITPOINTS) + ")" + " [" + SkillTracker.getGainedExperiencePerHour(Skill.HITPOINTS) + "]",12,95);
            g.drawString("Attack: " + Skills.getRealLevel(Skill.ATTACK) + " (+" + SkillTracker.getGainedLevels(Skill.ATTACK) + ")" + " [" + SkillTracker.getGainedExperiencePerHour(Skill.ATTACK) + "]",  12,107);
            g.drawString("Strength: " + Skills.getRealLevel(Skill.STRENGTH) + " (+" + SkillTracker.getGainedLevels(Skill.STRENGTH) + ")" + " [" + SkillTracker.getGainedExperiencePerHour(Skill.STRENGTH) + "]" ,12,119);
            g.drawString("Defence: " + Skills.getRealLevel(Skill.DEFENCE) + " (+" + SkillTracker.getGainedLevels(Skill.DEFENCE) + ")" + " [" + SkillTracker.getGainedExperiencePerHour(Skill.DEFENCE) + "]",12,131);
        }
    }
}
