package com.gmail.ggas.ui.command.sportsman;

import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.exception.SportsmanServiceException;
import com.gmail.ggas.service.Service;
import com.gmail.ggas.service.SportsmanService;
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
            sportsmanService.createPerson(params);
        }catch (Exception e){
            throw new CommandException(e);
        }
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);
    }
}
