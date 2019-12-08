package ui.sportsmancommands;

import ui.Command;
import ui.CommandResult;

import java.util.List;

public class UpdateSportsmanCommand implements Command {
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
        return null;
    }
}
