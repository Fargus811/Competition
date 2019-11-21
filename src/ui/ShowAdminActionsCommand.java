package ui;

import java.util.List;

public class ShowAdminActionsCommand implements Command {

    @Override
    public String getInstruction() {
        return "Доступные действия: создать-1, удалить-2, прочитать-3, обновить-4";
    }

    @Override
    public int paramsNumber() {
        return 1;
    }

    @Override
    public CommandResult process(List<String> params) {
        return new CommandResult(new ShowAdminActionsCommand(), null);
    }
}
