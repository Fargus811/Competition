package ui;

import ui.coachcommands.CreateCoachCommand;
import ui.coachcommands.DeleteCoachCommand;
import ui.coachcommands.ShowAllCoachesCommand;
import ui.coachcommands.UpdateCoachCommand;
import ui.sportsmancommands.CreatSporstmanCommand;
import ui.sportsmancommands.DeleteSportsmanCommand;
import ui.sportsmancommands.ShowAllSportsmenCommand;
import ui.sportsmancommands.UpdateSportsmanCommand;

import java.util.List;

public class ShowAdminActionsCommand implements Command {

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

        return "Выберите нужное действие";
    }

    @Override
    public int paramsNumber() {
        return 1;
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

