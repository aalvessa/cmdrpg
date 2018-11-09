package com.cmdgames.rpg.domain.scenario.interactions;

import com.cmdgames.rpg.domain.characters.ElderThing;
import com.cmdgames.rpg.domain.characters.Enemy;
import com.cmdgames.rpg.domain.Player;
import org.junit.Test;
import static org.junit.Assert.*;
public class BattleActionsTest {

    @Test
    public void doAttackTest(){
        Player player = new Player();
        player.setStrength(99);
        Enemy enemy = new ElderThing(99, 100, 100);
        enemy = BattleActions.doAttack(player, enemy);
        assertEquals(66, enemy.getHealth());
    }

    @Test
    public void getExperienceTest(){
        Player player = new Player();
        player.setStrength(10);
        player.setSpeed(10);
        Enemy enemy = new ElderThing(100, 100, 100);
        player = BattleActions.getExperience(player, enemy);
        assertEquals(60, player.getStrength());
        assertEquals(60, player.getSpeed());
    }

    @Test
    public void getHitTest(){
        Player player = new Player();
        player.setHealth(50);
        Enemy enemy = new ElderThing(0,100,0);
        player = BattleActions.getHit(player, enemy);
        assertEquals(40, player.getHealth());
    }

    @Test
    public void cannotRunTest(){
        Player player = new Player();
        player.setSpeed(100);
        Enemy enemy = new ElderThing(0,0,200);
        player.setSpeed(100);
        assertFalse(BattleActions.canRun(player, enemy));
    }

    @Test
    public void canRunTest(){
        Player player = new Player();
        player.setSpeed(200);
        Enemy enemy = new ElderThing(0,0,100);
        player.setSpeed(100);
        assertTrue(BattleActions.canRun(player, enemy));

    }
}
