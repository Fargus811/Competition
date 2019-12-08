package ui;

import service.UserService;

import java.util.List;

public class LoginCommand implements Command {
    private UserService userService = UserService.getInstance();

    @Override
    public String getInstruction() {
        return "Введидте логин и пароль:";
    }

    @Override
    public int getParamNumber() {
        return 2;
    }

    @Override
    public String[] getParamInstruction() {
        return new String[0];
    }

    @Override
    public CommandResult process(List<String> params) {
        boolean isLogined = userService.login(params.get(0), params.get(1));
        if (isLogined) {
            return new CommandResult(new ShowAdminActionsCommand(), "Вы авторизированны");
        } else {
            return new CommandResult(new LoginCommand(), "Неверный логин или пароль");
        }
    }
}
