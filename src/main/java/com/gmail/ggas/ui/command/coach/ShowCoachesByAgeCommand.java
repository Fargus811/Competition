package com.gmail.ggas.ui.command.coach;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.service.ICoachService;
import com.gmail.ggas.service.implservice.CoachService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;

import java.util.List;

public class ShowCoachesByAgeCommand implements Command {

    private static final String INSTRUCTION = "Находим тренера по возрасту";

    private static ICoachService coachService = CoachService.getInstance();

    private static final String[] paramInstructions = new String[]{"Введите возраст тренера"};

    @Override
    public String getInstruction() {
        return INSTRUCTION;
    }

    @Override
    public int getParamsNumber() {
        return paramInstructions.length;
    }

    @Override
    public String[] getParamInstructions() {
        return paramInstructions;
    }

    @Override
    public CommandResult process(List<String> params) {
        int age = Integer.parseInt(params.get(0));
        List<Coach> all = coachService.findCoachByAge(age);
        StringBuilder result = new StringBuilder();
        for (Coach coach : all) {
            result.append(coach);
            result.append("\n");
        }
        if (all.size() == 0) {
            result.append("Пустой список");
        }
        return new CommandResult(new ShowAdminActionsCommand(), result.toString());
    }

}
