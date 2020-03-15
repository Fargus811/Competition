package com.gmail.ggas.ui.command.coach;

import com.gmail.ggas.entity.User;
import com.gmail.ggas.service.Service;
import com.gmail.ggas.service.implservice.CoachService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;

import java.util.List;
import java.util.Scanner;

public class ShowAllCoachesCommand implements Command {

    private static final String INSTRUCTION = "Список тренеров:";

    private static final String PREVIOUS_PAGE ="PREV";

    private static final String NEXT_PAGE = "NEXT";

    private static Service coachService = CoachService.getInstance();

    @Override
    public String getInstruction() {
        return INSTRUCTION;
    }

    @Override
    public int getParamsNumber() {
        return 0;
    }

    @Override
    public String[] getParamInstructions() {
        return new String[0];
    }

    //TODO Сделать один класс для всех для вывода списков постранично
    @Override
    public CommandResult process(List<String> params) {
        List<User> all = coachService.findAll();
        StringBuilder result = new StringBuilder();
        if (all.size() < 11) {
            for (User coach : all) {
                result.append(coach);
                result.append("\n");
            }
            if (all.size() == 0) {
                result.append("Пустой список");
            }
            return new CommandResult(new ShowAdminActionsCommand(), result.toString());
        } else {
              return readWideList(all);
        }
    }

    private CommandResult readWideList(List<User> all) {
        int page = 1;
        int pageSize = 10;
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        for (; counter < pageSize * page; counter++) {
            try {
                System.out.println(all.get(counter));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("-----Конец списка-----"+'\n'+"-----"+PREVIOUS_PAGE+"-----" );
                if (sc.nextLine().equals(PREVIOUS_PAGE)) {
                    page--;
                    int counterLinesAtPage = counter%10 ;
                    counter= counter - pageSize  - counterLinesAtPage - 1 ;
                }}
                if (counter == page * pageSize - 1) {
                    System.out.println(NEXT_PAGE + "---" + PREVIOUS_PAGE);
                    String s = sc.nextLine();
                    if (s.equals(NEXT_PAGE)) {
                        page++;
                    } else if (s.equals(PREVIOUS_PAGE) && page != 1) {
                        page--;
                        counter= counter - (pageSize * 2) ;
                    } else if (s.equals("Exit")) {
                        sc.close();
                        return new CommandResult(new ShowAdminActionsCommand());
                    }
                }
            }
        return new CommandResult(new ShowAdminActionsCommand());
    }
}

