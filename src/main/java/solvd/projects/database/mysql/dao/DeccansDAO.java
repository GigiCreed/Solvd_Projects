package solvd.projects.database.mysql.dao;

import solvd.projects.database.interfaces.IDeccansDAO;
import solvd.projects.database.mysql.AbstractMySqlDAO;
import solvd.projects.database.tableclasses.Deccans;

import java.util.List;

public class DeccansDAO extends AbstractMySqlDAO implements IDeccansDAO {
    @Override
    public void create(Deccans object) {

    }

    @Override
    public Deccans getBy(Deccans object, Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void update(String setParameter, Deccans object, Long id) {

    }

    @Override
    public List<Deccans> getAllDeccans() {
        return null;
    }
}
