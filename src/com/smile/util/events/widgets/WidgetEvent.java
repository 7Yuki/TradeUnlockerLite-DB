package com.smile.util.events.widgets;

import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import static org.dreambot.api.methods.MethodProvider.*;

public class WidgetEvent {
    public WidgetEvent() {
    }

    /**
     *
     * @param config the PlayerSetting config for the style you want to change to
     * @param childID the WidgetChild ID of the style you want to choose
     * @param style the name of the style you are choosing
     * @return if your style actually changed
     */
    public boolean changeCombatStlye(int config, int childID, String style) {
        WidgetChild styleWidget = Widgets.getWidget(593).getChild(childID);
        if (PlayerSettings.getConfig(43) != config) {
            log("Switching to: " + style + " | Config: " + config);
            if (Tabs.isOpen(Tab.COMBAT)) {
                sleep(500,800);
                return styleWidget.interact() ? Tabs.openWithFKey(Tab.INVENTORY) : Tabs.openWithFKey(Tab.COMBAT);
            } else {
                Tabs.openWithFKey(Tab.COMBAT);
            }
        }
        return false;
    }
    /**
     *
     * @param config the PlayerSetting config for the style you want to change to
     * @param childID the WidgetChild ID of the style you want to choose
     * @return if your style actually changed
     */
    public boolean changeCombatStlye(int config, int childID) {
        WidgetChild styleWidget = Widgets.getWidget(593).getChild(childID);
        if (PlayerSettings.getConfig(43) != config) {
            if (Tabs.isOpen(Tab.COMBAT)) {
                sleep(680,850);
                return styleWidget.interact() ? Tabs.openWithFKey(Tab.INVENTORY) : Tabs.openWithFKey(Tab.COMBAT);
            } else {
                Tabs.openWithFKey(Tab.COMBAT);
            }
        }
        return false;
    }
}
