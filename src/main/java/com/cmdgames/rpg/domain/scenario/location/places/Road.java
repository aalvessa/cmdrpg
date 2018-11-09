package com.cmdgames.rpg.domain.scenario.location.places;

import com.cmdgames.rpg.domain.characters.ElderThing;
import com.cmdgames.rpg.domain.scenario.interactions.Battle;
import com.cmdgames.rpg.domain.scenario.location.Place;
import com.cmdgames.rpg.service.BannerService;

import java.util.ArrayList;
import java.util.List;

public class Road implements Place {

    private String place;
    private ElderThing elderThing;
    private BannerService bannerService;

    public Road(String place){
        this.place = place;
        this.bannerService = new BannerService();
        this.elderThing = new ElderThing(100,100,50);
    }

    @Override
    public String getPlaceDescription(){
        return this.place;
    }

    @Override
    public List<Battle> getPlaceEvents() {
        List<Battle> events = new ArrayList<>();
        Battle battle = new Battle(this.elderThing);
        events.add(battle);
        return events;
    }

    @Override
    public String getPlaceAscii() {
        return this.bannerService.getRoad();
    }
}
