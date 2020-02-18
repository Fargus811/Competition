package com.gmail.ggas.ui.command.sportsman;

import com.gmail.ggas.entity.Sportsman;
import com.gmail.ggas.service.SportsmanService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;

import java.util.List;

public class ShowAllSportsmenCommand implements Command {

    private static SportsmanService sportsmanService = SportsmanService.getInstance();

    @Override
    public String getInstruction() {
        return "Список тренеров:";
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
        List<Sportsman> all = sportsmanService.findAll();
        StringBuilder result = new StringBuilder();
        for (Sportsman sportsman : all) {
            result.append(sportsman);
            result.append("/n");
        }
        if (all.size() == 0){
            result.append("Пустой список");
        }
        return new CommandResult(new ShowAdminActionsCommand(), result.toString());

    }
}
