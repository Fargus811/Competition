package ui.command;

import java.util.List;

public interface Command {

    String getInstruction();

    int getParamsNumber();

    String[] getParamInstruction();

    CommandResult process(List<String> params);
}
