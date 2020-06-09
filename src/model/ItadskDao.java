package model;

import beans.Task;
import config.Database;
import interfaces.Itask;

import java.util.List;

public class ItadskDao  implements Itask {
    Database database  =  new Database() ;
    @Override
    public int add(Task ts) {
        String sql =  "INSERT INTO tasks VALUES (Null,?,?,?,?,?,?,?) " ;

        database.initPrepare(sql);
        int ok = 0  ;
        try {
            database.getPstm().setString(1,ts.getName());
            database.getPstm().setString(2,ts.getDescription());
            database.getPstm().setString(3,ts.getStartDate().toString());
            database.getPstm().setString(4,ts.getEndDate().toString());
            database.getPstm().setInt(5,ts.getProject().getId());
            database.getPstm().setInt(6,ts.getUser().getId());
            database.getPstm().setInt(7,ts.getState());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return ok;
    }

    @Override
    public Task get(int id) {
        return null;
    }

    @Override
    public List<Task> getTaskByProject(int id) {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }
}
