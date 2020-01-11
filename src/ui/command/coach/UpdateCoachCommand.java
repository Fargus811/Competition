package ui.command.coach;

import exception.CommandException;
import exception.CoachServiceException;
import service.CoachService;
import ui.command.Command;
import ui.command.CommandResult;
import ui.command.ShowAdminActionsCommand;

import java.util.List;

public class UpdateCoachCommand implements Command {

    private static final String INSTRUCTION = "Начинаем обновлять информацию о тренере";

    private static final String RESULT = "Информация о тренере успешно обновлена";

    private CoachService coachService = CoachService.getInstance();

    private static final String[] paramInstructions = new String[]{"Введите id тренера", "Ввeдите фамилию тренера", "Введите имя тренера",
            "Введите востраст тренера", "Введите пол тренара: MALE или FEMALE", "Введите старну тренера"
            , "Введите стоимость одной тренировки"};

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
            coachService.update(params);
        } catch (CoachServiceException e) {
            throw new CommandException(e);
        }
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);
    }
}
