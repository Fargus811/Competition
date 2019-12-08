package ui.coachcommands;

import service.CoachService;
import ui.Command;
import ui.CommandResult;
import ui.ShowAdminActionsCommand;

import java.util.List;

public class CreateCoachCommand implements Command {

    private static final String[] paramInstructions = new String[]{"Ввeдите фамилию тренера", "Введите имя тренера",
            "Введите востраст тренера", "Введите пол тренара: MALE или FEMALE", "Введите старну тренера"
            , "Введите стоимость одной тренировки"};

    private CoachService coachService = CoachService.getInstance();

    String result = "Тренер добавлен в список";

    @Override
    public String getInstruction() {
        return "Начинаем создавать тренера";
    }

    @Override
    public int getParamNumber() {
        return paramInstructions.length;
    }

    @Override
    public String[] getParamInstruction() {
        return paramInstructions;
    }

    @Override
    public CommandResult process(List<String> params) {
        coachService.createCoach(params);
        return new CommandResult(new ShowAdminActionsCommand(), result);

    }
}
