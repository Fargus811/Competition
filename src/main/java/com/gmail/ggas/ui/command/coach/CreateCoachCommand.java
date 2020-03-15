package com.gmail.ggas.ui.command.coach;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.service.implservice.CoachService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;
import org.apache.log4j.Logger;

import java.util.List;

public class CreateCoachCommand implements Command {

    private final static Logger log = Logger.getLogger(CreateCoachCommand.class);

    private static final String INSTRUCTION = "Начинаем создавать тренера";

    private static final String RESULT = "Тренер добавлен в список";

    private static final String[] paramInstructions = new String[]{"Ввeдите фамилию тренера", "Введите имя тренера",
            "Введите востраст тренера", "Введите пол тренара: MALE или FEMALE", "Введите логин тренера"
            , "Введите стоимость одной тренировки","Введите ранк тренера","Введите email",
            "Введите пароль для вашего аккаунта", "Введите стаж работы"};

    private static final int AGE_INDEX = 2;

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
            int age = Integer.parseInt(params.get(AGE_INDEX));//CMD+ALT+C
            int cost = Integer.parseInt(params.get(5));
            double workExp = Double.valueOf(params.get(9));
            Sex sex = Sex.valueOf(params.get(3));
            Coach coach = new Coach();
            coach.setFirstName(params.get(0));
            coach.setLastName(params.get(1));
            coach.setAge(age);
            coach.setSex(sex);
            coach.setLogin(params.get(4));
            coach.setCost(cost);
            coach.setRank(params.get(6));
            coach.setEmail(params.get(7));
            coach.setPassword(params.get(8));
            coach.setWorkExperience(workExp);
            coach.setRole(Role.COACH);
            coachService.create(coach);
        } catch (Exception e) {
            throw new CommandException(e);
        }
        return new CommandResult(new ShowAdminActionsCommand(), RESULT);

    }
}
