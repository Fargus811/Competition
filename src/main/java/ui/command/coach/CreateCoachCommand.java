package ui.command.coach;

import exception.CoachServiceException;
import exception.CommandException;
import service.CoachService;
import ui.command.Command;
import ui.command.CommandResult;
import ui.command.ShowAdminActionsCommand;

import java.util.List;

public class CreateCoachCommand implements Command {

    private static final String INSTRUCTION = "Начинаем создавать тренера";

    private static final String RESULT = "Тренер добавлен в список";

    private static final String[] paramInstructions = new String[]{"Ввeдите фамилию тренера", "Введите имя тренера",
            "Введите востраст тренера", "Введите пол тренара: MALE или FEMALE", "Введите старну тренера"
            , "Введите стоимость одной тренировки"};

    private CoachService coachService = CoachService.getInstance();

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
    public CommandResult process(List<String> params) throws CommandException {
        try {
            coachService.createCoach(params);
        } catch (CoachServiceException e) {
            throw new CommandException(e);
        }
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);

    }
}
