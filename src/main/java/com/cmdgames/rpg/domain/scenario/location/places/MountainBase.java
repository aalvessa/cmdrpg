package com.cmdgames.rpg.domain.scenario.location.places;

import com.cmdgames.rpg.domain.characters.ElderThing;
import com.cmdgames.rpg.domain.scenario.interactions.Battle;
import com.cmdgames.rpg.domain.scenario.location.Place;
import com.cmdgames.rpg.service.BannerService;

import java.util.ArrayList;
import java.util.List;

public class MountainBase implements Place {

    private ElderThing elderThing1;
    private ElderThing elderThing2;
    private BannerService bannerService;

    public MountainBase(){
        this.bannerService = new BannerService();
        this.elderThing1 = new ElderThing(100,100,50);
        this.elderThing2 = new ElderThing(110,90,80);
    }

    @Override
    public String getPlaceDescription(){
        return "You´ve got to the mountain base";
    }

    @Override
    public List<Battle> getPlaceEvents() {
        List<Battle> events = new ArrayList<>();
        Battle battle1 = new Battle(this.elderThing1);
        Battle battle2 = new Battle(this.elderThing2);
        events.add(battle1);
        events.add(battle2);
        return events;
    }

    @Override
    public String getPlaceAscii() {
        return this.bannerService.getBase();
    }

}
