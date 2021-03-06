package it.mineblock.bedwars;

import it.mineblock.bedwars.enums.GamePhases;
import it.mineblock.mbcore.spigot.Chat;
import org.bukkit.Bukkit;

public class GameHandler {
    public boolean isBroadcastWaiting = false;
    private Map map = new Map();
    private GamePhases phase;

    public GameHandler() {
        setPhase(GamePhases.BOOTING);
    }

    public void setPhase(GamePhases phase) {
        this.phase = phase;
        phaseChanged();
    }

    public Map getMap() {
        return map;
    }

    public GamePhases getPhase() {
        return phase;
    }

    private void phaseChanged() {
        if(phase.equals(GamePhases.BOOTING)) {
            booting();
        }
        else if(phase.equals(GamePhases.WAITING)) {
            waiting();
        }
        else if(phase.equals(GamePhases.STARTING)) {
            starting();
        }
        else if(phase.equals(GamePhases.RUNNING)) {
            running();
        }
        else if(phase.equals(GamePhases.ENDING)) {
            ending();
        }
        else if(phase.equals(GamePhases.REBOOTING)) {
            rebooting();
        }
        else if(phase.equals(GamePhases.CONFIGURATION)) {
            configuration();
        }
    }

    private void booting() {
        map.init();
    }

    private void waiting() {

    }

    private void starting() {

    }

    private void running() {

    }

    private void ending() {

    }

    private void rebooting() {

    }

    private void configuration() {
        if(Bukkit.getOnlinePlayers().size() != 0) {
            Bukkit.broadcastMessage(Chat.getTranslated("&eWelcome to &6MineBedwars &emap configuration system!"));
            Bukkit.broadcastMessage(Chat.getTranslated("&eTo start the creation of the map position yourself in the world you want to configure and enter the command &c/mbw create&e."));
        } else {
            isBroadcastWaiting = true;
        }
    }
}
