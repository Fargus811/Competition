package ui.command;

import exception.CommandException;

import java.util.List;

public interface Command {

    String getInstruction();

    int getParamsNumber();

    String[] getParamInstructions();

    CommandResult process(List<String> params) throws CommandException;
}
