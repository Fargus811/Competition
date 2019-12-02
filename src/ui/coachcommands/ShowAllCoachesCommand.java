package ui.coachcommands;

import entity.Coach;
import service.CoachService;
import ui.Command;
import ui.CommandResult;
import ui.ShowAdminActionsCommand;

import java.util.List;

public class ShowAllCoachesCommand implements Command {

    CoachService coachService = CoachService.getInstance();



    @Override
    public String getInstruction() {
        return "Список тренеров:";
    }

    @Override
    public int paramsNumber() {
        return 0;
    }

    @Override
    public CommandResult process(List<String> params) {
        List<Coach> all = coachService.findAll();
        StringBuilder result = new StringBuilder();
        for (Coach coach : all) {
            result.append(coach);
            result.append("/n");
        }
        if (all.size() == 0){
            result.append("Пустой список");
        }
       return new CommandResult(new ShowAdminActionsCommand(), result.toString());

    }

}
