package ui.command.sportsman;

import exception.CommandException;
import exception.SportsmanServiceException;
import service.SportsmanService;
import ui.command.Command;
import ui.command.CommandResult;
import ui.command.ShowAdminActionsCommand;

import java.util.List;

public class CreatSporstmanCommand implements Command {

    private static final String RESULT ="Спортсмен добавлен в список";

    private static SportsmanService sportsmanService = SportsmanService.getInstance();

    private String[] paramsInstruction = new String[]{"Введите имя спортсмена","Введите фамилию спортсмена",
            "Введите возраст спортсмена","Введите вес спортсмена","Введите логин спортсмена","Введите пароль",
            "Введите пол спортсмена:MALE или FEMALE","Введите email"};

    @Override
    public String getInstruction() {
        return null;
    }

    @Override
    public int getParamsNumber() {
        return 6;
    }

    @Override
    public String[] getParamInstructions() {
        return new String[0];
    }

    @Override
    public CommandResult process(List<String> params) throws CommandException{
        try{
            sportsmanService.createSportsman(params);
        }catch (SportsmanServiceException e){
            throw new CommandException(e);
        }
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);
    }
}
