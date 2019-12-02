package ui.coachcommands;

import service.CoachService;
import ui.Command;
import ui.CommandResult;
import ui.ShowAdminActionsCommand;

import java.util.List;

public class CreateCoachCommand implements Command {

    CoachService coachService = CoachService.getInstance();

    String result = "Тренер добавлен в список";

    @Override
    public String getInstruction() {
        return "Начинаем создавать тренера";
    }

    @Override
    public int paramsNumber() {
        return 0;
    }

    @Override
    public CommandResult process(List<String> params) {
        coachService.createCoach();
        return new CommandResult(new ShowAdminActionsCommand(), result);

    }
}
