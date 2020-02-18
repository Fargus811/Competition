package com.gmail.ggas.ui.command.sportsman;

import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.exception.SportsmanServiceException;
import com.gmail.ggas.service.SportsmanService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;

import java.util.List;

public class UpdateSportsmanCommand implements Command {
    private static final String INSTRUCTION = "Начинаем обновлять информацию о спортсмене";

    private static final String RESULT = "Информация о спортсмене успешно обновлена";

    private SportsmanService sportsmanService = SportsmanService.getInstance();

    private String[] paramsInstruction = new String[]{"Введите id тренера", "Введите имя спортсмена",
            "Введите фамилию спортсмена", "Введите возраст спортсмена", "Введите вес спортсмена",
            "Введите логин спортсмена", "Введите пароль",
            "Введите пол спортсмена:MALE или FEMALE", "Введите email"};


    @Override
    public String getInstruction() {
        return INSTRUCTION;
    }

    @Override
    public int getParamsNumber() {
        return paramsInstruction.length;
    }

    @Override
    public String[] getParamInstructions() {
        return paramsInstruction;
    }

    @Override
    public CommandResult process(List<String> params) throws CommandException {
        try {
            sportsmanService.update(params);
        } catch (SportsmanServiceException e) {
            throw new CommandException(e);
        }
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);
    }
}

