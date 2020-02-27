package com.gmail.ggas.ui.command;

import com.gmail.ggas.service.UserService;

import java.util.List;
import java.util.Scanner;

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
        if (all.size() <= 10) {
            for (Object object : all) {
                result.append(object);
                result.append("/n");
            }
            if (all.size() == 0) {
                result.append("Пустой список");
            }
        } else {
            int pageSize = 10;
            int page = 1;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                all.stream().skip((page - 1) * pageSize).limit(pageSize).forEach(System.out::println);
                if (page != 1) {
                    System.out.println("NEXT - - - PREV");
                    String s = scanner.next();
                    if (s.equals("NEXT")) {
                        page++;
                    } else if (s.equals("PREV")) {
                        page--;
                    } else {
                        return new CommandResult(new ShowAdminActionsCommand());
                    }

                }
            }
        }
        return new CommandResult(new ShowAdminActionsCommand());
    }
}
