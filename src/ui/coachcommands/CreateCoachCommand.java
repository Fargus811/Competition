package ui.coachcommands;

import ui.Command;
import ui.CommandResult;

import java.util.List;

public class CreateCoachCommand implements Command {
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
        return null;
    }
}
