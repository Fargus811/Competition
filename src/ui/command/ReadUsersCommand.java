package ui.command;

import entity.Role;
import entity.User;

import java.util.Arrays;
import java.util.List;

public class ReadUsersCommand implements Command {

    @Override
    public String getInstruction() {
        return "Список пользователей:";
    }

    @Override
    public int getParamsNumber() {
        return 0;
    }

    @Override
    public String[] getParamInstruction() {
        return new String[0];
    }

    @Override
    public CommandResult process(List<String> params) {
        String result = Arrays.asList(
                new User(1, "Dan", Role.COACH),
                new User(1, "Dan", Role.COACH)
        ).toString();
        return new CommandResult(new ShowAdminActionsCommand(), result);
    }
}
