package ui.command;

import service.UserService;

import java.util.List;

public class ShowAllUsersCommand implements Command{

    private static UserService userService = UserService.getInstance();

    @Override
    public String getInstruction() {
        return "Список всех пользователей:";
    }

    @Override
    public int getParamsNumber() {
        return 0;
    }

    @Override
    public String[] getParamInstructions() {
        return new String[0];
    }

    @Override
    public CommandResult process(List<String> params) {
        List<Object> all = userService.showAll();
        StringBuilder result = new StringBuilder();
        for (Object object : all) {
            result.append(object);
            result.append("/n");
        }
        if (all.size() == 0){
            result.append("Пустой список");
        }
        return new CommandResult(new ShowAdminActionsCommand(), result.toString());
    }
}
