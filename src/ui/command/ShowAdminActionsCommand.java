package ui.command;

import ui.command.coach.CreateCoachCommand;
import ui.command.coach.DeleteCoachCommand;
import ui.command.coach.ShowAllCoachesCommand;
import ui.command.coach.UpdateCoachCommand;
import ui.command.sportsman.CreatSporstmanCommand;
import ui.command.sportsman.DeleteSportsmanCommand;
import ui.command.sportsman.ShowAllSportsmenCommand;
import ui.command.sportsman.UpdateSportsmanCommand;

import java.util.List;

//import ui.command.coach.DeleteCoachCommand;
//import ui.command.coach.UpdateCoachCommand;

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
                commandResult = new CommandResult(new ShowAllSportsmenCommand(), null);
                break;

            case "2":
                commandResult = new CommandResult(new ShowAllCoachesCommand(), null);
                break;

            case "3":
                commandResult = new CommandResult(new ShowAllUsersCommand(),null);
                break;

            case "4":
                commandResult = new CommandResult(new CreateCoachCommand(),null);
                break;

            case "5":
                commandResult = new CommandResult(new CreatSporstmanCommand(),null);
                break;

            case "6":
               commandResult = new CommandResult(new DeleteCoachCommand(),null);
               break;

            case "7":
                commandResult = new CommandResult(new DeleteSportsmanCommand(),null);

           case "8":
                commandResult = new CommandResult(new UpdateCoachCommand(),null);
               break;

            case "9":
                commandResult = new CommandResult(new UpdateSportsmanCommand(),null);

            default:
                commandResult = new CommandResult(new ShowAdminActionsCommand(), null);
                break;
        }
        return commandResult;
    }


}

