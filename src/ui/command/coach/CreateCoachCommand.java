package ui.command.coach;

import service.CoachService;
import ui.command.Command;
import ui.command.CommandResult;
import ui.command.ShowAdminActionsCommand;

import java.util.List;

public class CreateCoachCommand implements Command {

    private static final String RESULT = "Тренер добавлен в список";

    private static final String[] paramInstructions = new String[]{"Ввeдите фамилию тренера", "Введите имя тренера",
            "Введите востраст тренера", "Введите пол тренара: MALE или FEMALE", "Введите старну тренера"
            , "Введите стоимость одной тренировки"};

    private CoachService coachService = CoachService.getInstance();

    @Override
    public String getInstruction() {
        return "Начинаем создавать тренера";
    }

    @Override
    public int getParamsNumber() {
        return paramInstructions.length;
    }

    @Override
    public String[] getParamInstruction() {
        return paramInstructions;
    }

    @Override
    public CommandResult process(List<String> params) {
        coachService.createCoach(params);
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);

    }
}
