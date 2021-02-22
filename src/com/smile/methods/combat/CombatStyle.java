package com.smile.methods.combat;

import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.utilities.StatusBar;
import org.dreambot.api.wrappers.widgets.WidgetChild;
import static org.dreambot.api.methods.MethodProvider.*;

public class CombatStyle {
    public static boolean changeCombatStlye(int config, int childID, String style) {
        WidgetChild accurateWidget = Widgets.getWidget(593).getChild(childID);
        if (PlayerSettings.getConfig(43) != config) {
            StatusBar.info("Switching combat style: " + style, false);
            log("Switching to: " + style + " | Config: " + config);
            if (Tabs.isOpen(Tab.COMBAT)) {
                sleep(500,800);
                if (accurateWidget.interact() && PlayerSettings.getConfig(43) == config) {
                    StatusBar.info("Now gaining " + style + " XP", false);
                    sleep(500,800);
                    Tabs.openWithFKey(Tab.INVENTORY);
                    return true;
                }
            } else {
                Tabs.openWithFKey(Tab.COMBAT);
            }
        }
        return false;
    }
    public static int getCombatStyle() {
        return PlayerSettings.getConfig(43);
    }
}
