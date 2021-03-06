package com.gmail.ggas.ui.command.coach;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.service.Service;
import com.gmail.ggas.service.implservice.CoachService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;

import java.util.List;

public class UpdateCoachCommand implements Command {

    private static final String INSTRUCTION = "Начинаем обновлять информацию о тренере";

    private static final String RESULT = "Информация о тренере успешно обновлена";

    private Service coachService = CoachService.getInstance();

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
            int age = Integer.parseInt(params.get(3));
            int cost = Integer.parseInt(params.get(6));
            double workExp = Double.valueOf(params.get(10));
            Sex sex = Sex.valueOf(params.get(4));
            Coach coach = new Coach();
            coach.setId(Long.parseLong(params.get(0)));
            coach.setFirstName(params.get(1));
            coach.setLastName(params.get(2));
            coach.setAge(age);
            coach.setSex(sex);
            coach.setLogin(params.get(5));
            coach.setCost(cost);
            coach.setRank(params.get(7));
            coach.setEmail(params.get(8));
            coach.setPassword(params.get(9));
            coach.setWorkExperience(workExp);
            coach.setRole(Role.COACH);
            coachService.update(coach);
        } catch (Exception e) {
            throw new CommandException(e);
        }
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);
    }
}
