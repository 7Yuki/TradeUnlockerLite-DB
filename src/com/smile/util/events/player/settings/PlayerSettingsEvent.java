package com.smile.util.events.player.settings;

import org.dreambot.api.methods.settings.PlayerSettings;

public class PlayerSettingsEvent {
    /**
     *
     * @return The style's config
     */
    public static int getCombatStyle() {
        return PlayerSettings.getConfig(43);
    }

}
