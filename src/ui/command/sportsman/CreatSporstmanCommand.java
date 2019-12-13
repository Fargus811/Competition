package ui.command.sportsman;

import service.SportsmanService;
import ui.command.Command;
import ui.command.CommandResult;
import ui.command.ShowAdminActionsCommand;

import java.util.List;

public class CreatSporstmanCommand implements Command {

    private static SportsmanService sportsmanService = SportsmanService.getInstance();

    String[] paramsInstruction = new String[]{"k"};

    String result = "Спортсмен добавлен в список";

    @Override
    public String getInstruction() {
        return null;
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
        return new CommandResult(new ShowAdminActionsCommand(), result);
    }
}