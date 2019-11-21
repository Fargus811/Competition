package ui;

import java.util.List;

public interface Command {

    String getInstruction();

    int paramsNumber();
    CommandResult process(List<String> params);
}
