package ui;

import java.util.List;

public interface Command {

    String getInstruction();

    int getParamNumber();

    String[] getParamInstruction();

    CommandResult process(List<String> params);
}
