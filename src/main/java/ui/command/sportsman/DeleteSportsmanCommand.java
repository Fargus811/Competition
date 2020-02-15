package ui.command.sportsman;

import entity.Sportsman;
import service.SportsmanService;
import ui.command.Command;
import ui.command.CommandResult;
import ui.command.ShowAdminActionsCommand;

import java.util.List;

public class DeleteSportsmanCommand implements Command {
    private static final String INSTRUCTION = "Введите id спортсмена";

    private static final String RESULT = "Удаление прошло успешно";

    private SportsmanService sportsmanService = SportsmanService.getInstance();

    @Override
    public String getInstruction() {
        return INSTRUCTION;
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
        sportsmanService.deleteById(Long.parseLong(params.get(0)));
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);

    }
}
