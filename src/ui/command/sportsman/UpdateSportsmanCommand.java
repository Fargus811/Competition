package ui.command.sportsman;

import ui.command.Command;
import ui.command.CommandResult;

import java.util.List;

public class UpdateSportsmanCommand implements Command {
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
        return null;
    }
}
