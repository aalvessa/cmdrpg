package com.cmdgames.rpg.domain.scenario.location.places;

import com.cmdgames.rpg.domain.characters.Shoggoth;
import com.cmdgames.rpg.domain.scenario.interactions.Battle;
import com.cmdgames.rpg.domain.scenario.location.Place;
import com.cmdgames.rpg.service.BannerService;

import java.util.ArrayList;
import java.util.List;

public class OldTemple implements Place {

    private String place;
    private Shoggoth shoggoth;
    private BannerService bannerService;

    public OldTemple(String place){
        this.place = place;
        this.bannerService = new BannerService();
        this.shoggoth = new Shoggoth();
    }

    @Override
    public String getPlaceDescription(){
        return this.place;
    }

    @Override
    public List<Battle> getPlaceEvents() {
        List<Battle> events = new ArrayList<>();
        Battle battle = new Battle(this.shoggoth);
        events.add(battle);
        return events;
    }

    @Override
    public String getPlaceAscii() {
        return this.bannerService.getOldTemple();
    }

}
