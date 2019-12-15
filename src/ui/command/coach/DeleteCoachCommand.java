package ui.command.coach;

import service.CoachService;
import ui.command.Command;
import ui.command.CommandResult;
import ui.command.ShowAdminActionsCommand;

import java.util.List;

public class DeleteCoachCommand implements Command {

    private static final String INSTRUCTION = "Введите id тренера";

    private static final String RESULT = "Удаление прошло успешно";

    private CoachService coachService = CoachService.getInstance();

    @Override
    public String getInstruction() {
        return INSTRUCTION;
    }

    @Override
    public int getParamsNumber() {
        return 1;
    }

    @Override
    public String[] getParamInstruction() {
        return new String[0];
    }

    @Override
    public CommandResult process(List<String> params) {
        coachService.deleteById(Long.parseLong(params.get(0)));
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);

    }
}
