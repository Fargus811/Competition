package com.gmail.ggas.service;

import com.gmail.ggas.entity.Coach;

import java.util.List;

public interface ICoachService extends Service<Coach> {

    List<Coach> findCoachByAge(List<String> params);
}
