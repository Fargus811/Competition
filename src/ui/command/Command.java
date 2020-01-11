package ui.command;

import java.util.List;

public interface Command {

    String getInstruction();

    int getParamsNumber();

    String[] getParamInstructions();

    CommandResult process(List<String> params);
}
