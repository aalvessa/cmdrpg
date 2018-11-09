package com.cmdgames.rpg.front;

import com.cmdgames.rpg.domain.scenario.exception.ArgumentNotAllowedException;
import com.cmdgames.rpg.utils.CommandLineUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandPanel {


    public static int getStartPanelOption() {
        boolean isValid = false;
        String command = null;

        while (!isValid) {
            CommandLineUtils.print("Do you want to restart the game or continue the existing?");
            CommandLineUtils.print("1. Continue ");
            CommandLineUtils.print("2. Start new game ");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            isValid = areTheOptionsValid(command);
            if(!isValid)
                CommandLineUtils.print("Choose one of the options below:");
        }
        return Integer.valueOf(command);
    }

    public static String getPlayerName() {
        boolean isValid = false;
        String command = null;

        while (!isValid) {
            CommandLineUtils.print(" What's your name ?");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            isValid = isStringValid(command);
            if(!isValid)
                CommandLineUtils.print("Type your name below");
        }
        return command;
    }

    protected static boolean isStringValid(final String command){
        return !command.trim().isEmpty();
    }


    protected static boolean areTheOptionsValid(final String command){
        if(!(command.equals("1") || command.equals("2")))
            return false;
        return true;
    }

    public static List<String> isNavigationCommandValid(final String command){
        List<String> errors = new ArrayList<>();
        if(command.isEmpty())
            errors.add("Command must not be empty\n");
        try {
            int option = Integer.valueOf(command);
            if(option < 1 || option > 5)
                errors.add("Command must be a number from 1 to 5");
        }catch (NumberFormatException ex){
            errors.add("The Command must be a number\n");
        }
        return errors;
    }

    public static Integer readAndCheckNavigation() throws ArgumentNotAllowedException {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<String> errors = CommandPanel.isNavigationCommandValid(command);
        errors.forEach(
                error -> CommandLineUtils.print(error));
        if(!errors.isEmpty())
            throw new ArgumentNotAllowedException();
        return Integer.valueOf(command);
    }

}
