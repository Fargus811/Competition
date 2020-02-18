package com.gmail.ggas.ui.command;

import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.exception.SportsmanServiceException;

import java.util.List;

public class ShowCoachActionsCommand implements Command {
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
    public CommandResult process(List<String> params) throws CommandException, SportsmanServiceException {
        return null;
    }
}

