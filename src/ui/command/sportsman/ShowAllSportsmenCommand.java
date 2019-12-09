package ui.command.sportsman;

import entity.Sportsman;
import service.SportsmanService;
import ui.command.Command;
import ui.command.CommandResult;
import ui.command.ShowAdminActionsCommand;

import java.util.List;

public class ShowAllSportsmenCommand implements Command {

    private static SportsmanService sportsmanService = SportsmanService.getInstance();

    @Override
    public String getInstruction() {
        return "Список тренеров:";
    }

    @Override
    public int getParamsNumber() {
        return 0;
    }

    @Override
    public String[] getParamInstruction() {
        return new String[0];
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
