package com.cmdgames.rpg;

import com.cmdgames.rpg.domain.Player;
import com.cmdgames.rpg.domain.scenario.exception.ArgumentNotAllowedException;
import com.cmdgames.rpg.domain.scenario.exception.NavigationNotAllowedException;
import com.cmdgames.rpg.domain.scenario.interactions.Battle;
import com.cmdgames.rpg.domain.scenario.interactions.BattleContext;
import com.cmdgames.rpg.domain.scenario.location.Map;
import com.cmdgames.rpg.domain.scenario.location.Place;
import com.cmdgames.rpg.front.CommandPanel;
import com.cmdgames.rpg.service.MapService;
import com.cmdgames.rpg.service.PlayerService;
import com.cmdgames.rpg.utils.CommandLineUtils;

public class EventEngine {

    public void navigate (final Map map, final Player player, Integer command, final PlayerService playerService, final MapService mapService){
        try {
            command = newPlayerStep(map);
            if(command == 5){
                playerService.savePlayer(player);
                mapService.saveLocation(map.getLocation());
                System.exit(0);
            }
            Place actualPlace = map.navigate(command);
            interactWith(actualPlace, player);
        } catch (NavigationNotAllowedException | ArgumentNotAllowedException ex) {
            CommandLineUtils.print(ex.getMessage());
        }
        navigate(map, player, command, playerService, mapService);
    }

    private void reactToEvent(final Battle event, final Player player) {

        if(event.getEnemy().getHealth() <= 0){
            CommandLineUtils.print("There is a dead " + event.getEnemy().getName() + " here");
            return;
        }
        CommandLineUtils.print(String.format("You are in a fight against an %s",  event.getEnemy().getName()));
        CommandLineUtils.print(String.format("%s says %s", event.getEnemy().getName(), event.getEnemy().getEnemyMessage()));
        CommandLineUtils.print(event.getEventMessage());
        BattleContext battleContext = new BattleContext();
        try {
            battleContext = doEventAction(event, player, battleContext);
        } catch (ArgumentNotAllowedException ex) {
            CommandLineUtils.print(ex.getMessage());
            reactToEvent(event, player);
        }
        if(battleContext.isRun() || battleContext.isFinished())
            return;
        if(battleContext.isDead())
            System.exit(0);
        reactToEvent(event, player);
    }

    private BattleContext doEventAction(Battle event, Player player, BattleContext battleContext) throws ArgumentNotAllowedException {
        Integer command = CommandPanel.readAndCheckNavigation();
        battleContext.setPlayer(player);
        battleContext.setCommandAction(command);
        battleContext = event.doPlayerAction(battleContext);
        CommandLineUtils.print(battleContext.getMessage());
        battleContext = event.doEnemyAction(battleContext);
        CommandLineUtils.print(battleContext.getMessage());
        return battleContext;
    }

    private void interactWith(final Place actualPlace, final Player player) {
        CommandLineUtils.print(actualPlace.getPlaceAscii());
        CommandLineUtils.print(actualPlace.getPlaceDescription());
        actualPlace.getPlaceEvents().forEach(event -> {
            reactToEvent(event, player);
        });
    }

    private Integer newPlayerStep(final Map map) throws ArgumentNotAllowedException {
        CommandLineUtils.print(map.getAllowedDirectionsMessage());
        CommandLineUtils.print("5. Save and exit game");
        return CommandPanel.readAndCheckNavigation();
    }

}
