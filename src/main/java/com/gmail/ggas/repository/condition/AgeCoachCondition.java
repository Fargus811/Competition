package com.gmail.ggas.repository.condition;

import com.gmail.ggas.entity.Coach;

public class AgeCoachCondition extends CoachCondition {

    private int age;

    public AgeCoachCondition(int age) {
        this.age = age;
    }

    @Override
    public boolean check(Coach coach) {
        return coach.getAge() == age;
    }
}
