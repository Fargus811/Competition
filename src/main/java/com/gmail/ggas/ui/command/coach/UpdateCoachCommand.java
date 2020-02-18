package com.gmail.ggas.ui.command.coach;

import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.exception.CoachServiceException;
import com.gmail.ggas.service.CoachService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;

import java.util.List;

public class UpdateCoachCommand implements Command {

    private static final String INSTRUCTION = "Начинаем обновлять информацию о тренере";

    private static final String RESULT = "Информация о тренере успешно обновлена";

    private CoachService coachService = CoachService.getInstance();

    private static final String[] paramInstructions = new String[]{"Введите id тренера","Ввeдите фамилию тренера", "Введите имя тренера",
            "Введите востраст тренера", "Введите пол тренара: MALE или FEMALE", "Введите логин тренера"
            , "Введите стоимость одной тренировки","Введите ранк тренера","Введите email",
            "Введите пароль для вашего аккаунта", "Введите стаж работы",};

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
