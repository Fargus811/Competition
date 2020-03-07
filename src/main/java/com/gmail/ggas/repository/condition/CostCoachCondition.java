package com.gmail.ggas.repository.condition;

import com.gmail.ggas.entity.Coach;

public class CostCoachCondition extends CoachCondition {

    private int cost;

    public CostCoachCondition(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean check(Coach coach) {
        return coach.getCost() == cost;
    }
}

