package com.gmail.ggas.ui;

import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.exception.SportsmanServiceException;
import org.apache.log4j.Logger;
import com.gmail.ggas.repository.FileConfigurator;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ExitCommand;
import com.gmail.ggas.ui.command.LoginCommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;

public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws CommandException,SecurityException, SportsmanServiceException {
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/log4j.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        FileConfigurator dbManager = new FileConfigurator();
        System.out.println(dbManager.initFiles());
        Scanner scanner = new Scanner(System.in);
        Command currentCommand = new LoginCommand();
        while (true) {
            System.out.println(currentCommand.getInstruction());
            List<String> params = new ArrayList<>();
            String[] paramInstruction = currentCommand.getParamInstructions();
            for (int i = 0; i < currentCommand.getParamsNumber(); i++) {
                if (paramInstruction.length != 0) {
                    System.out.println(paramInstruction[i]);
                }
                String input = scanner.next();
                if ("exit".equals(input)) {
                    currentCommand = new ExitCommand();

                }
                params.add(input);
            }
            CommandResult commandResult = currentCommand.process(params);
            if (commandResult.getResult() != null) {
                System.out.println(commandResult.getResult());
            }
            currentCommand = commandResult.getCommand();
            if (currentCommand == null) {
                break;
            }
        }
    }
}
