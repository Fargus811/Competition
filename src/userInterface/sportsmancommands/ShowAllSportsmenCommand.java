package userInterface.sportsmancommands;

import entity.Coach;
import entity.Sportsman;
import service.SportsmanService;
import userInterface.Command;
import userInterface.CommandResult;
import userInterface.ShowAdminActionsCommand;

import java.util.List;

public class ShowAllSportsmenCommand implements Command {

    SportsmanService sportsmanService = SportsmanService.getInstance();

    @Override
    public String getInstruction() {
        return "Список тренеров:";
    }

    @Override
    public int paramsNumber() {
        return 0;
    }

    @Override
    public CommandResult process(List<String> params) {
        List<Sportsman> all = sportsmanService.findAll();
        StringBuilder result = new StringBuilder();
        for (Sportsman sportsman : all) {
            result.append(sportsman);
            result.append("/n");
        }
        if (all.size() == 0){
            result.append("Пустой список");
        }
        return new CommandResult(new ShowAdminActionsCommand(), result.toString());

    }
}
