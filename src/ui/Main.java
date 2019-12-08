package ui;

import repository.FileConfigurator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FileConfigurator dbManager = new FileConfigurator();
        System.out.println(dbManager.filesExist());

        Scanner scanner = new Scanner(System.in);
        Command currentCommand = new LoginCommand();
        while (true) {
            System.out.println(currentCommand.getInstruction());
            List<String> params = new ArrayList<>();
            String[] paramInstruction = currentCommand.getParamInstruction();
            for (int i = 0; i < currentCommand.getParamNumber(); i++) {
                if (paramInstruction.length != 0) {
                    System.out.println(paramInstruction[i]);
                }
                String input = scanner.next();
                if ("exit".equals(scanner)) {
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
