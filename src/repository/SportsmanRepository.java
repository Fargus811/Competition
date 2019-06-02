package repository;

import entity.Sportsman;

import java.util.List;

public interface SportsmanRepository {
    public void save(Sportsman sportsman);
    public List<Sportsman> findAll();
}
