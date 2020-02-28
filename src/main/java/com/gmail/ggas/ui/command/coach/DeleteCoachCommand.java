package com.gmail.ggas.ui.command.coach;

import com.gmail.ggas.service.CoachService;
import com.gmail.ggas.service.Service;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;

import java.util.List;

public class DeleteCoachCommand implements Command {

    private static final String INSTRUCTION = "Введите id тренера";

    private static final String RESULT = "Удаление прошло успешно";

    private Service coachService = CoachService.getInstance();

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
        coachService.deleteById(Long.parseLong(params.get(0)));
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);

    }
}
