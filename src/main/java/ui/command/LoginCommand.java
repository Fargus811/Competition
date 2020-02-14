package ui.command;

import entity.Role;
import exception.UserLoginException;
import service.UserService;

import java.util.List;

public class LoginCommand implements Command {

    private static final String ENTER_LOGIN_AND_PASSWORD = "Введидте логин и пароль:";

    private static final String TRUE_RESULT = "Вы авторизированны";

    private static final String FALSE_RESULT = "Неверный логин или пароль";

    private UserService userService = UserService.getInstance();

    @Override
    public String getInstruction() {
        return ENTER_LOGIN_AND_PASSWORD;
    }

    @Override
    public int getParamsNumber() {
        return 2;
    }

    @Override
    public String[] getParamInstructions() {
        return new String[0];
    }

    @Override
    public CommandResult process(List<String> params) throws UserLoginException {
        Role isLogined = userService.login(params.get(0), params.get(1));
        if (isLogined == Role.ADMIN) {
            return new CommandResult(new ShowAdminActionsCommand(), TRUE_RESULT);
        } else if (isLogined == Role.COACH) {
            return new CommandResult(new ShowCoachActionsCommand(), TRUE_RESULT);
        } else {

        }
        return new CommandResult(new LoginCommand(),FALSE_RESULT);
    }
}
