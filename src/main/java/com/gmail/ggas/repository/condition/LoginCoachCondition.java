package com.gmail.ggas.repository.condition;

import com.gmail.ggas.entity.Coach;

public class LoginCoachCondition extends CoachCondition {

    private String login;

    public LoginCoachCondition(String login) {
        this.login = login;
    }

    @Override
    public boolean check(Coach coach) {
        return coach.getLogin().equals(login);
    }
}
