package userInterface;

import service.UserService;

import java.util.List;

public class LoginCommand implements Command {

    private UserService userService = new UserService();

    @Override
    public String getInstruction() {
        return "Введидте логин и пароль:";
    }

    @Override
    public int paramsNumber() {
        return 2;
    }

    @Override
    public CommandResult process(List<String> params) {
        boolean isLogined = userService. login(params.get(0), params.get(1));
        if (isLogined) {
            return new CommandResult(new ShowAdminActionsCommand(), null);
        } else {
            return new CommandResult(new LoginCommand(), null);
        }
    }
}
