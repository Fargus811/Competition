package com.gmail.ggas.ui.command;

import com.gmail.ggas.ui.command.coach.*;
import com.gmail.ggas.ui.command.sportsman.CreatSporstmanCommand;
import com.gmail.ggas.ui.command.sportsman.DeleteSportsmanCommand;
import com.gmail.ggas.ui.command.sportsman.ShowAllSportsmenCommand;
import com.gmail.ggas.ui.command.sportsman.UpdateSportsmanCommand;

import java.util.List;

public class ShowAdminActionsCommand implements Command {

    private static final String INSTRUCTION_RESULT = "Выберите нужное действие";

    @Override
    public String getInstruction() {
        System.out.println("Доступные действия:");
        System.out.println("1 - посмотреть всех спортсменов");
        System.out.println("2 - посмотреть всех тренеров");
        System.out.println("3 - посмотреть всех позьзователей");
        System.out.println("4 - создать тренера");
        System.out.println("5 - создать спортсмена");
        System.out.println("6 - удалить тренера");
        System.out.println("7 - удалить спортсмена");
        System.out.println("8 - обновить информацию о тренере");
        System.out.println("9 - обновить информацию о спортсмене");

        return INSTRUCTION_RESULT;
    }

    @Override
    public int getParamsNumber() {
        return 1;
    }

    @Override
    public String[] getParamInstructions() {
        return new String[0];
    }

    @Override
    public CommandResult process(List<String> params) {
        CommandResult commandResult;
        switch (params.get(0)) {

            case "1":
                commandResult = new CommandResult(new ShowAllSportsmenCommand());
                break;

            case "2":
                commandResult = new CommandResult(new ShowAllCoachesCommand());
                break;

            case "3":
                commandResult = new CommandResult(new ShowAllUsersCommand());
                break;

            case "4":
                commandResult = new CommandResult(new CreateCoachCommand());
                break;

            case "5":
                commandResult = new CommandResult(new CreatSporstmanCommand());
                break;

            case "6":
               commandResult = new CommandResult(new DeleteCoachCommand());
               break;

            case "7":
                commandResult = new CommandResult(new DeleteSportsmanCommand());
                break;

           case "8":
                commandResult = new CommandResult(new UpdateCoachCommand());
               break;

            case "9":
                commandResult = new CommandResult(new UpdateSportsmanCommand());
                break;

            case "10":
                commandResult = new CommandResult(new ShowCoachesByWorkExpCommand());
            default:
                commandResult = new CommandResult(new ShowAdminActionsCommand());
                break;
        }
        return commandResult;
    }


}

