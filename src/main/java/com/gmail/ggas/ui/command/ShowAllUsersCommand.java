package com.gmail.ggas.ui.command;

import com.gmail.ggas.service.UserService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowAllUsersCommand implements Command {

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
        if (all.size()<=10) {
            for (Object object : all) {
                result.append(object);
                result.append("/n");
            }
            if (all.size() == 0) {
                result.append("Пустой список");
            }
        }
        else {
            List<Object> currentUsers = new ArrayList<>();
            List<Object> nextUsers = new ArrayList<>();
            List<Object> previosUsers = new ArrayList<>();
            for (int i = 0; i <10 ; i++) {
                currentUsers.add(all.get(i));
                for (Object object : currentUsers) {
                    result.append(object);
                    result.append("/n");
                    result.append("prev --- next");
                }
            }
        }
        return new CommandResult(new ShowAdminActionsCommand());
    }
}
