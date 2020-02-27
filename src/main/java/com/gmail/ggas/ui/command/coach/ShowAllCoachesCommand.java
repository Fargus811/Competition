package com.gmail.ggas.ui.command.coach;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.service.CoachService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowAllCoachesCommand implements Command {

    private static final String INSTRUCTION = "Список тренеров:";

    private static CoachService coachService = CoachService.getInstance();

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

    @Override
    public CommandResult process(List<String> params) {
        List<Coach> all = coachService.findAll();
        StringBuilder result = new StringBuilder();
        if (all.size() < 11) {
            for (Coach coach : all) {
                result.append(coach);
                result.append("\n");
            }
            if (all.size() == 0) {
                result.append("Пустой список");
            }
            return new CommandResult(new ShowAdminActionsCommand(), result.toString());
        } else {
              readWideList(all);
        }
        return new CommandResult(new ShowAdminActionsCommand());
    }

    private CommandResult readWideList(List<Coach> all) {
        int page = 1;
        int pageSize = 10;
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        big_loop:
        for (; counter < pageSize * page; counter++) {
            try {
                System.out.println(all.get(counter));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("-----Конец списка-----"+'\n'+"---------PREV---------" );
                if (sc.nextLine().equals("PREV")) {
                    page--;
                    int counterLinesAtPage = counter%10 ;
                    counter= counter - pageSize  - counterLinesAtPage - 1 ;
                    continue big_loop;
                }}
                if (counter == page * pageSize - 1) {
                    System.out.println("NEXT --- PREV");
                    String s = sc.nextLine();
                    if (s.equals("NEXT")) {
                        page++;
                        //  counter++;
                    } else if (s.equals("PREV") && page != 1) {
                        page--;
                        counter= counter - (pageSize * 2) ;
                    } else if (s.equals("Exit")) {
                        sc.close();
                        return new CommandResult(new ShowAdminActionsCommand());
                        //
                    }
                }
            }


        return new CommandResult(new ShowAdminActionsCommand());
    }
}

