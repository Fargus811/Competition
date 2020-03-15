package com.gmail.ggas.ui.command.sportsman;

import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.entity.Sportsman;
import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.service.Service;
import com.gmail.ggas.service.implservice.SportsmanService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;

import java.util.List;

public class UpdateSportsmanCommand implements Command {
    private static final String INSTRUCTION = "Начинаем обновлять информацию о спортсмене";

    private static final String RESULT = "Информация о спортсмене успешно обновлена";

    private Service sportsmanService = SportsmanService.getInstance();

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
            int age = Integer.parseInt(params.get(3));
            double weight = Double.valueOf(params.get(4));
            Sex sex = Sex.valueOf(params.get(7));
            Sportsman sportsman = new Sportsman();
            sportsman.setId(Long.parseLong(params.get(0)));
            sportsman.setFirstName(params.get(1));
            sportsman.setLastName(params.get(2));
            sportsman.setLogin(params.get(5));
            sportsman.setPassword(params.get(6));
            sportsman.setEmail(params.get(8));
            sportsman.setAge(age);
            sportsman.setSex(sex);
            sportsman.setWeight(weight);
            sportsman.setRole(Role.SPORTSMEN);
            sportsmanService.update(sportsman);
        } catch (Exception e) {
            throw new CommandException(e);
        }
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);
    }
}

