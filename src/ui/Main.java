package ui;

import repository.FileConfigurator;
import ui.command.Command;
import ui.command.CommandResult;
import ui.command.ExitCommand;
import ui.command.LoginCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
