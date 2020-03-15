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

public class CreatSporstmanCommand implements Command {

    private static final String RESULT ="Спортсмен добавлен в список";

    private static final String INSTRUCTION = "Начинаем создавать спортсмена";


    private static Service sportsmanService = SportsmanService.getInstance();

    private String[] paramsInstruction = new String[]{"Введите имя спортсмена","Введите фамилию спортсмена",
            "Введите возраст спортсмена","Введите вес спортсмена","Введите логин спортсмена","Введите пароль",
            "Введите пол спортсмена:MALE или FEMALE","Введите email"};

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
    public CommandResult process(List<String> params) throws CommandException{
        try{
            int age = Integer.parseInt(params.get(2));
            double weight = Double.valueOf(params.get(3));
            Sex sex = Sex.valueOf(params.get(6));
            Sportsman sportsman = new Sportsman();
            sportsman.setFirstName(params.get(0));
            sportsman.setLastName(params.get(1));
            sportsman.setLogin(params.get(4));
            sportsman.setPassword(params.get(5));
            sportsman.setEmail(params.get(7));
            sportsman.setAge(age);
            sportsman.setSex(sex);
            sportsman.setWeight(weight);
            sportsman.setRole(Role.SPORTSMEN);
            sportsmanService.create(sportsman);
        }catch (Exception e){
            throw new CommandException(e);
        }
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);
    }
}
