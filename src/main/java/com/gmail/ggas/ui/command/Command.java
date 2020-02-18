package com.gmail.ggas.ui.command;

import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.exception.SportsmanServiceException;

import java.util.List;

public interface Command {

    String getInstruction();

    int getParamsNumber();

    String[] getParamInstructions();

    CommandResult process(List<String> params) throws CommandException, SportsmanServiceException;
}
