package com.cmdgames.rpg.front;

import static org.junit.Assert.*;
import org.junit.Test;


public class CommandPanelTest {


    @Test
    public void validateInitialCommandTest(){
        assertEquals(true, CommandPanel.areTheOptionsValid("1"));
        assertEquals(true, CommandPanel.areTheOptionsValid("2"));
        assertNotEquals(true, CommandPanel.areTheOptionsValid("0"));
        assertNotEquals(true, CommandPanel.areTheOptionsValid("3"));
        assertNotEquals(true, CommandPanel.areTheOptionsValid("A"));
        assertNotEquals(true, CommandPanel.areTheOptionsValid(" "));
    }

    @Test
    public void isStringValidTest(){
        assertFalse(CommandPanel.isStringValid(" "));
        assertFalse(CommandPanel.isStringValid(""));
    }

    @Test
    public void isNavigationCommantValidTest(){
        assertTrue(CommandPanel.isNavigationCommandValid("1").isEmpty());
        assertTrue(CommandPanel.isNavigationCommandValid("2").isEmpty());
        assertTrue(CommandPanel.isNavigationCommandValid("3").isEmpty());
        assertTrue(CommandPanel.isNavigationCommandValid("4").isEmpty());
        assertTrue(CommandPanel.isNavigationCommandValid("5").isEmpty());

        assertFalse(CommandPanel.isNavigationCommandValid(" ").isEmpty());
        assertFalse(CommandPanel.isNavigationCommandValid("a").isEmpty());
        assertFalse(CommandPanel.isNavigationCommandValid("--").isEmpty());
        assertFalse(CommandPanel.isNavigationCommandValid("").isEmpty());
        assertFalse(CommandPanel.isNavigationCommandValid("6").isEmpty());
    }


}
