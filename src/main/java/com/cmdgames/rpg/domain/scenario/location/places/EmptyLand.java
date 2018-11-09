package com.cmdgames.rpg.domain.scenario.location.places;

import com.cmdgames.rpg.domain.scenario.interactions.Battle;
import com.cmdgames.rpg.domain.scenario.location.Place;

import java.util.ArrayList;
import java.util.List;

public class EmptyLand implements Place {

    @Override
    public String getPlaceDescription() {
        return "You´ve got to an empty land";
    }

    @Override
    public String getPlaceAscii() {
        return "";
    }

    @Override
    public List<Battle> getPlaceEvents() {
        return new ArrayList<>();
    }
}
