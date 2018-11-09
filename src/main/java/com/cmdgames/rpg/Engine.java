package com.cmdgames.rpg;

import com.cmdgames.rpg.domain.Player;
import com.cmdgames.rpg.domain.scenario.location.Location;
import com.cmdgames.rpg.domain.scenario.location.Map;
import com.cmdgames.rpg.domain.scenario.location.maps.MadnessMountains;
import com.cmdgames.rpg.front.CommandPanel;
import com.cmdgames.rpg.service.BannerService;
import com.cmdgames.rpg.service.MapService;
import com.cmdgames.rpg.service.PlayerService;
import com.cmdgames.rpg.utils.CommandLineUtils;

public final class Engine {

    private static final int NEW_GAME = 2;

    public void startGame(){

        BannerService bannerService = new BannerService();
        PlayerService playerService = new PlayerService();
        MapService mapService = new MapService();
        Map map = new MadnessMountains();

        CommandLineUtils.print(bannerService.getTitle());
        CommandLineUtils.print("Welcome to the Artic");
        Player player = playerService.retrieveSavedPlayer();
        Location location = mapService.retrieveSavedLocation();

        if(player == null) {
            player = setupPlayer(new Player());
            playerService.savePlayer(player);
        }else{
            int option = CommandPanel.getStartPanelOption();
            if(option == NEW_GAME) {
                player = setupPlayer(new Player());
                playerService.savePlayer(player);
            }else{
                map.setLocation(location);
            }
        }

        EventEngine eventEngine = new EventEngine();
        eventEngine.navigate(map, player, null, playerService, mapService);
    }

    private Player setupPlayer(final Player player){
        player.setName(CommandPanel.getPlayerName());
        player.setHealth(100);
        player.setSpeed(100);
        player.setStrength(100);
        return player;
    }

}