package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Command currentCommand = new LoginCommand();
        while (true) {
            System.out.println(currentCommand.getInstruction());
            List<String> params = new ArrayList<>();
            for (int i = 0; i < currentCommand.paramsNumber(); i++) {
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
