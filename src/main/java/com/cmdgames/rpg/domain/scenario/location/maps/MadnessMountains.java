package com.cmdgames.rpg.domain.scenario.location.maps;

import com.cmdgames.rpg.domain.scenario.location.Map;
import com.cmdgames.rpg.domain.scenario.location.places.EmptyLand;
import com.cmdgames.rpg.domain.scenario.location.places.MountainBase;
import com.cmdgames.rpg.domain.scenario.location.places.OldTemple;
import com.cmdgames.rpg.domain.scenario.location.places.Road;
import com.cmdgames.rpg.domain.scenario.location.Place;

public final class MadnessMountains extends Map {


    @Override
    protected Place[][] createMapLayout() {
        Place[][] map = {
                getFirstLevelMap(),
                getSecondLevelMap(),
                getThirdLevelMap(),
                getFourthLevelMap()
        };
        this.map = map;
        return map;
    }

    protected Place[] getFirstLevelMap(){
        Place[] lowerMap = {new EmptyLand(), new Road("Road to Old Town"), new OldTemple("Old Temple")};
        return lowerMap;
    }

    protected Place[] getSecondLevelMap(){
        Place[] lowerMap = {new EmptyLand(), new MountainBase(), new EmptyLand()};
        return lowerMap;
    }

    protected Place[] getThirdLevelMap(){
        Place[] lowerMap = {new EmptyLand(), new Road("Road to Mountain Base"), new EmptyLand()};
        return lowerMap;
    }

    protected Place[] getFourthLevelMap(){
        Place[] lowerMap = {new EmptyLand(), new EmptyLand(), new EmptyLand()};
        return lowerMap;
    }

}