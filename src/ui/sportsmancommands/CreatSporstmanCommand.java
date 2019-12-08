package ui.sportsmancommands;

import service.SportsmanService;
import ui.Command;
import ui.CommandResult;
import ui.ShowAdminActionsCommand;

import java.util.List;

public class CreatSporstmanCommand implements Command {
    SportsmanService sportsmanService = SportsmanService.getInstance();

    String[] paramsInstruction = new String[]{"k"};

    String result = "Спортсмен добавлен в список";

    @Override
    public String getInstruction() {
        return null;
    }

    @Override
    public int getParamNumber() {
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
