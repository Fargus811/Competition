package ui.command;

import java.util.List;

public class ExitCommand implements Command {

    @Override
    public String getInstruction() {
        return null;
    }

    @Override
    public int getParamsNumber() {
        return 0;
    }

    @Override
    public String[] getParamInstructions() {
        return new String[0];
    }

    @Override
    public CommandResult process(List<String> params) {
        return new CommandResult(null, null);
    }

}
