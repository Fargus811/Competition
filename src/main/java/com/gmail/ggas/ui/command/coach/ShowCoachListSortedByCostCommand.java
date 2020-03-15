package com.gmail.ggas.ui.command.coach;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.entity.User;
import com.gmail.ggas.exception.CommandException;
import com.gmail.ggas.exception.SportsmanServiceException;
import com.gmail.ggas.service.Service;
import com.gmail.ggas.service.implservice.CoachService;
import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;

import java.util.ArrayList;
import java.util.List;

public class ShowCoachListSortedByCostCommand implements Command {

    private static final String INSTRUCTION = "Списк тренеров отсортированный по стоимости от большего к меньшему ";

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

    @Override
    public CommandResult process(List<String> params) throws CommandException, SportsmanServiceException {
        List<User> all = coachService.findAll();
        List<Coach> coaches = new ArrayList<>();
        for (User coach : all
        ) {
            coaches.add((Coach) coach);
        }
        StringBuilder result = new StringBuilder();
        return null;
    }

    private static void bubbleSort(List<Coach> coaches) {
        int size = coaches.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (coaches.get(j).getCost() > coaches.get(j + 1).getCost()) {

                }

            }
        }
    }
}
