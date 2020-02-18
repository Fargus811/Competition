package com.gmail.ggas.ui.command.coach;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.service.CoachService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;

import java.util.List;

public class ShowCoachesByWorkExpCommand implements Command {

    private static final String INSTRUCTION = "Находим тренера по стажу работы";

    private static CoachService coachService = CoachService.getInstance();

    private static final String[] paramInstructions = new String[]{"Введите стаж работы тренера"};

    @Override
    public String getInstruction() {
        return INSTRUCTION;
    }

    @Override
    public int getParamsNumber() {
        return paramInstructions.length ;
    }

    @Override
    public String[] getParamInstructions() {
        return paramInstructions;
    }

    @Override
    public CommandResult process(List<String> params) throws CommandException {
        List<Coach> all = coachService.findAll();
        StringBuilder result = new StringBuilder();
        for (Coach coach : all) {
            if (coach.getWorkExperience()>=Double.parseDouble(params.get(0))){
            result.append(coach);
            result.append("\n");}
        }
        if (all.size() == 0) {
            result.append("Пустой список");
        }
        return new CommandResult(new ShowAdminActionsCommand(), result.toString());
    }
}
